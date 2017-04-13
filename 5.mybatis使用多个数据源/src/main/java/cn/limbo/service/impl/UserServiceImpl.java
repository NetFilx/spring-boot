package cn.limbo.service.impl;

import cn.limbo.dao.cluster.CityDao;
import cn.limbo.dao.master.UserDao;
import cn.limbo.domain.City;
import cn.limbo.domain.User;
import cn.limbo.exception.NoSuchCityException;
import cn.limbo.exception.NoSuchUserException;
import cn.limbo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by limbo on 2017/4/10.
 */

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private CityDao cityDao;

	@Override
	public User findByName(String userName) throws
			NoSuchUserException
			,NoSuchCityException
	{

		User user = userDao.findByName(userName);
		City city = cityDao.findByName("温州");

		if(Objects.isNull(user)){
			throw new NoSuchUserException("没有这个用户!");
		}
		else if (Objects.isNull(city)){
			throw new NoSuchCityException("没有这个城市");
		}
		else{
			user.setCity(city);
		}

		return user;
	}
}
