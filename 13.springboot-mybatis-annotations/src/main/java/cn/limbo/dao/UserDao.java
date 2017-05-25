package cn.limbo.dao;

import cn.limbo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by limbo on 2017/5/25.
 */

@Mapper  //标志为Mybatis的Mapper
public interface UserDao {


	/**
	 * 根据用户名字查询用户信息
	 * @param userName  用户名
	 * @return
	 */
	@Select("SELECT * FROM user WHERE user_name = #{userName}")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "user_name"),
			@Result(property = "description", column = "description")
	})
	User findByName(@Param("userName") String userName);

	/**
	 * 查找全部的User
	 * @return
	 */
	@Select("SELECT * FROM user")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "user_name"),
			@Result(property = "description", column = "description")
	})
	List<User> findAll();

}
