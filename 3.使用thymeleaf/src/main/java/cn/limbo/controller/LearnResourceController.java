package cn.limbo.controller;

import cn.limbo.domain.LearnResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limbo on 2017/4/9.
 */

@Controller
@RequestMapping(value = "/learn")
public class LearnResourceController {

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		List<LearnResource> learnList = new ArrayList<>();
		learnList.add(new LearnResource("官方参考文档", "Spring Boot Reference Guide", "http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application"));
		learnList.add(new LearnResource("官方SpringBoot例子", "官方SpringBoot例子", "https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples"));
		learnList.add(new LearnResource("龙国学院", "Spring Boot 教程系列学习", "http://www.roncoo.com/article/detail/125488"));
		learnList.add(new LearnResource("嘟嘟MD独立博客", "Spring Boot干货系列 ", "http://tengj.top/"));
		learnList.add(new LearnResource("后端编程嘟", "Spring Boot教程和视频 ", "http://www.toutiao.com/m1559096720023553/"));
		learnList.add(new LearnResource("程序猿DD", "Spring Boot系列", "http://www.roncoo.com/article/detail/125488"));
		learnList.add(new LearnResource("纯洁的微笑", "Sping Boot系列文章", "http://www.ityouknow.com/spring-boot"));
		learnList.add(new LearnResource("CSDN——小当博客专栏", "Sping Boot学习", "http://blog.csdn.net/column/details/spring-boot.html"));
		learnList.add(new LearnResource("梁桂钊的博客", "Spring Boot 揭秘与实战", "http://blog.csdn.net/column/details/spring-boot.html"));
		learnList.add(new LearnResource("林祥纤博客系列", "从零开始学Spring Boot ", "http://412887952-qq-com.iteye.com/category/356333"));

		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("learnList", learnList);
		return modelAndView;

	}

	@RequestMapping(value = "/template")
	public ModelAndView index2() {
		List<LearnResource> learnList = new ArrayList<>();
		learnList.add(new LearnResource("官方参考文档", "Spring Boot Reference Guide", "http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application"));
		learnList.add(new LearnResource("官方SpringBoot例子", "官方SpringBoot例子", "https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples"));
		learnList.add(new LearnResource("龙国学院", "Spring Boot 教程系列学习", "http://www.roncoo.com/article/detail/125488"));
		learnList.add(new LearnResource("嘟嘟MD独立博客", "Spring Boot干货系列 ", "http://tengj.top/"));
		learnList.add(new LearnResource("后端编程嘟", "Spring Boot教程和视频 ", "http://www.toutiao.com/m1559096720023553/"));
		learnList.add(new LearnResource("程序猿DD", "Spring Boot系列", "http://www.roncoo.com/article/detail/125488"));
		learnList.add(new LearnResource("纯洁的微笑", "Sping Boot系列文章", "http://www.ityouknow.com/spring-boot"));
		learnList.add(new LearnResource("CSDN——小当博客专栏", "Sping Boot学习", "http://blog.csdn.net/column/details/spring-boot.html"));
		learnList.add(new LearnResource("梁桂钊的博客", "Spring Boot 揭秘与实战", "http://blog.csdn.net/column/details/spring-boot.html"));
		learnList.add(new LearnResource("林祥纤博客系列", "从零开始学Spring Boot ", "http://412887952-qq-com.iteye.com/category/356333"));

		ModelAndView modelAndView = new ModelAndView("/template");
		modelAndView.addObject("learnList", learnList);
		return modelAndView;

	}
}
