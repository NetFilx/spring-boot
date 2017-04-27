package cn.limbo.consume;

import cn.limbo.api.UserService;
import cn.limbo.domain.User;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/27.
 */
//这里将 CityDubboConsumerService 注入 Spring 容器，是为了更方便的获取该 Bean，然后验证这个 Dubbo 调用是否成功
@Component
public class UserConsumerService {

	//@Reference(version = “1.0.0”) 通过该注解，订阅该接口版本为 1.0.0 的 Dubbo 服务。
	@Reference(version = "1.0.0")
	UserService userService;

	public void printUser() {
		long id = 1;
		User u = userService.findUserById(id);
		System.out.println(u);
	}

}
