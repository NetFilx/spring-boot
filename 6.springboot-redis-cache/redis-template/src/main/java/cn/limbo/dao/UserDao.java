package cn.limbo.dao;

import cn.limbo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 * Created by limbo on 2017/4/21.
 */
@Repository
public interface UserDao {
	/**
	 * 获取所有的用户
	 * @return
	 */
	List<User> findAllUser();

	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User findById(@Param("id")Long id);

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
