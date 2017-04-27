package cn.limbo.service;

import cn.limbo.api.UserService;
import cn.limbo.domain.User;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by limbo on 2017/4/27.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
	@Override
	public User findUserById(Long id) {
		return new User(id,"wyh","SpringBoot-Dubbox");
	}
}
