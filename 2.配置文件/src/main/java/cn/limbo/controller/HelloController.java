package cn.limbo.controller;

import cn.limbo.domain.ConfigBean;
import cn.limbo.domain.ConfigTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by limbo on 2017/4/7.
 */

@RestController
public class HelloController {

//	@Value("${cn.limbo.name}")
//	private String name;
//
//	@Value("${cn.limbo.want}")
//	private String want;

//	@Autowired
//	ConfigBean configBean;

	@Autowired
	ConfigTestBean configBean;

	@RequestMapping("/")
	public String index(){
		//return name+" "+want;
		return configBean.getName()+" "+configBean.getWant();
	}

}
