package cn.limbo.api;

import cn.limbo.domain.User;

/**
 * Created by limbo on 2017/4/27.
 */
public interface UserService {

	User findUserById(Long id);

}
