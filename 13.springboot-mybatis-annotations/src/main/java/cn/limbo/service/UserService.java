package cn.limbo.service;

import cn.limbo.domain.User;

import java.util.List;

/**
 * Created by limbo on 2017/5/25.
 */
public interface UserService {

	/**
	 * 根据用户名字查询用户信息
	 * @param userName
	 * @return
	 */
	User findUserByName(String userName);

	/**
	 * 查找全部的用户
	 * @return
	 */
	List<User> findAllUser();

}
