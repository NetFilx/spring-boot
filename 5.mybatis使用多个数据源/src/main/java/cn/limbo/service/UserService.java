package cn.limbo.service;

import cn.limbo.domain.User;
import cn.limbo.exception.NoSuchCityException;
import cn.limbo.exception.NoSuchUserException;

/**
 * Created by limbo on 2017/4/10.
 */
public interface UserService {

	User findByName(String userName) throws NoSuchUserException, NoSuchCityException;

}
