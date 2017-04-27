package cn.limbo.service;

import cn.limbo.api.UserService;
import cn.limbo.domain.User;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by limbo on 2017/4/27.
 */
// 注册为 Dubbo 服务
//@Service 注解标识为 Dubbo 服务，并通过 version 指定了版本号。
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
	@Override
	public User findUserById(Long id) {
		return new User(id,"wyh","SpringBoot-Dubbox");
	}
}
