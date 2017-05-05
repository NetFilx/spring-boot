package cn.limbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by limbo on 2017/5/5.
 */
@Controller
public class HelloController {


	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "login";
	}

}
