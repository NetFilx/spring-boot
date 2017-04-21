package cn.limbo.controller;

import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by limbo on 2017/4/21.
 */

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findOneCity(@PathVariable("id") Long id){
		return userService.findUserById(id);
	}

	@RequestMapping(value = "/user",method = RequestMethod.POST)
	public void createUser(@RequestBody User user){
		userService.saveUser(user);
	}

	@RequestMapping(value = "/user",method = RequestMethod.PUT)
	public void modifyUser(@RequestBody User user){
		userService.updateUser(user);
	}

	@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> findAllUser(){
		return userService.findAllUser();
	}

}
