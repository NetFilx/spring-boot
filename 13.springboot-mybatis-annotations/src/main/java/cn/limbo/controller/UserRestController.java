package cn.limbo.controller;

import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by limbo on 2017/5/25.
 */


@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/user",method = RequestMethod.GET)
	public User findOneUser(@RequestParam(value = "userName",required = true) String userName){
		return userService.findUserByName(userName);
	}


	@RequestMapping(value = "/api/user/all",method = RequestMethod.GET)
	public List<User> findAll(){
		return userService.findAllUser();
	}

}
