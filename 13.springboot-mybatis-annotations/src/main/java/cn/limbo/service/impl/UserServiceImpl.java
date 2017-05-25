package cn.limbo.service.impl;

import cn.limbo.dao.UserDao;
import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by limbo on 2017/5/25.
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User findUserByName(String userName) {
		return userDao.findByName(userName);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}

}
