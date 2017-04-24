package cn.limbo.service;

import cn.limbo.domain.User;

import java.util.List;

/**
 * 用户业务接口
 * Created by limbo on 2017/4/21.
 */
public interface UserService {

	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	User findUserById(Long id);

	/**
	 * 找到所有的用户
	 * @return
	 */
	List<User> findAllUser();

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	Long saveUser(User user);

	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	Long updateUser(User user);

	/**
	 * 根据用户id删除用户
	 * @param id
	 * @return
	 */
	Long deleteUser(Long id);

}
