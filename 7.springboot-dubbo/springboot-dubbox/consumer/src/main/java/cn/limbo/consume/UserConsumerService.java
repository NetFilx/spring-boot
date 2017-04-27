package cn.limbo.consume;

import cn.limbo.api.UserService;
import cn.limbo.domain.User;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/27.
 */

@Component
public class UserConsumerService {

	@Reference(version = "1.0.0")
	UserService userService;

	public void printUser() {
		long id = 1;
		User u = userService.findUserById(id);
		System.out.println(u);
	}

}
