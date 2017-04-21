package cn.limbo.service.impl;

import cn.limbo.dao.UserDao;
import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by limbo on 2017/4/21.
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisTemplate redisTemplate;


	/**
	 * 获取用户逻辑：
	 * 如果缓存存在，从缓存中获取用户信息
	 * 如果缓存不存在，从 DB 中获取用户信息，然后插入缓存
	 */
	public User findUserById(Long id) {
		String key = "user_" + id;
		ValueOperations<String, User> operations = redisTemplate.opsForValue();

		//缓存存在
		boolean hasKey = redisTemplate.hasKey(key);

		if (hasKey) {
			User user = operations.get(key);

			LOGGER.info("UserServiceImpl.findUserById() : 从缓存中获取了用户 >>" + user);
			return user;
		}

		User user = userDao.findById(id);
		operations.set(key, user, 10, TimeUnit.MINUTES);
		LOGGER.info("UserServiceImpl.findUserById() : 用户插入缓存 >> " + user);

		return user;
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public Long saveUser(User user) {
		return userDao.saveUser(user);
	}

	/**
	 * 更新用户逻辑：
	 * 如果缓存存在，删除
	 * 如果缓存不存在，不操作
	 */
	@Override
	public Long updateUser(User user) {
		Long ret = userDao.updateUser(user);

		// 缓存存在，删除缓存
		String key = "user_" + user.getId();
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);

			LOGGER.info("UserServiceImpl.updateUser() : 从缓存中删除用户" + user);
		}

		return ret;
	}

	@Override
	public Long deleteUser(Long id) {

		Long ret = userDao.deleteUser(id);

		//缓存存在删除缓存
		String key = "user_" + id;
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);

			LOGGER.info("UserServiceImpl.deleteUser() : 从缓存中删除城市 ID" + id);
		}
		return ret;

	}
}
