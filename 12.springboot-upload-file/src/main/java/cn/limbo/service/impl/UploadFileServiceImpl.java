package cn.limbo.service.impl;

import cn.limbo.config.UploadFileProperties;
import cn.limbo.exception.UploadFileException;
import cn.limbo.exception.UploadFileNotFoundException;
import cn.limbo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by limbo on 2017/5/11.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

	private final Path rootLocation;

	@Autowired
	public UploadFileServiceImpl(UploadFileProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void init() {
		try{
			Files.createDirectory(rootLocation);
		}catch (IOException e){
			throw new UploadFileException("Could not initialize upload",e);
		}
	}

	@Override
	public void upload(MultipartFile file) {

		try {
			if (file.isEmpty()) {
				throw new UploadFileException("Failed to upload empty file" + file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			throw new UploadFileException("Failed to up load file" + file.getOriginalFilename(), e);
		}

	}

	@Override
	public Stream<Path> loadAll() {

		try {
			return Files.walk(this.rootLocation, 1)
					.filter(path -> !path.equals(this.rootLocation))
					.map(path -> this.rootLocation.relativize(path));
		} catch (IOException e) {
			throw new UploadFileException("Failed to read upload files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new UploadFileNotFoundException("Could not read file: " + filename);
			}
		} catch (MalformedURLException e) {
			throw new UploadFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
}
