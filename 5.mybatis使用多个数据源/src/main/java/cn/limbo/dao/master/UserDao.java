package cn.limbo.dao.master;

import cn.limbo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by limbo on 2017/4/10.
 */

@Mapper
public interface UserDao {


	User findByName(@Param("userName") String userName);

}
