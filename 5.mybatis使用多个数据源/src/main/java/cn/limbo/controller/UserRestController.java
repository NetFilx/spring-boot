package cn.limbo.controller;

import cn.limbo.domain.User;
import cn.limbo.exception.NoSuchCityException;
import cn.limbo.exception.NoSuchUserException;
import cn.limbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by limbo on 2017/4/10.
 */

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/user",method = RequestMethod.GET)
	public User findByName(@RequestParam(value="userName") String userName){
		User user = null;
		try{
			user = userService.findByName(userName);
		} catch (NoSuchUserException e) {
			System.err.println(e.toString());
		} catch (NoSuchCityException e) {
			System.err.println(e.toString());
		}

		return user;
	}

}
