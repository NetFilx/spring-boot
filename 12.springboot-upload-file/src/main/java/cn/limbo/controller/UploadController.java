package cn.limbo.controller;

import cn.limbo.exception.UploadFileNotFoundException;
import cn.limbo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by limbo on 2017/5/11.
 */
@Controller
public class UploadController {


	private final UploadFileService service;

	@Autowired
	public UploadController(UploadFileService service){
		this.service = service;
	}

	@GetMapping("/")
	public String listUploadFiles(Model model) throws IOException{
		model.addAttribute("files",service
				.loadAll()
		        .map(path -> MvcUriComponentsBuilder
		                            .fromMethodName(UploadController.class,"serveFile",path.getFileName().toString())
		                            .build().toString())
		        .collect(Collectors.toList()));
		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = service.loadAsResource(filename);
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
				.body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
		service.upload(file);
		redirectAttributes.addFlashAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
		return "redirect:/";
	}

	@ExceptionHandler(UploadFileNotFoundException.class)
	public ResponseEntity handleUploadFileNotFound(UploadFileNotFoundException e){
		return ResponseEntity.notFound().build();
	}
}
