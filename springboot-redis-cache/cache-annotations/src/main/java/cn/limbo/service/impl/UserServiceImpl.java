package cn.limbo.service.impl;

import cn.limbo.dao.UserDao;
import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by limbo on 2017/4/21.
 */
@Service
@CacheConfig(cacheNames = {"userCache"}) //可以指定key的生成器 如：keyGenerator = "keyGenerator" 这个与key是互斥的
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDao userDao;

	@Override
	@Cacheable(key = "#p0")
	public User findUserById(Long id) {
		return userDao.findById(id);
	}

	@Override
	@Cacheable
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	@CachePut(key = "#p0.id")
	public Long saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	@CachePut(key = "#p0.id")
	public Long updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	@CacheEvict(key = "#p0") //移除指定key的数据
	public Long deleteUser(Long id) {
		return userDao.deleteUser(id);
	}
}
