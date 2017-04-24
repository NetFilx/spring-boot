package cn.limbo;

import cn.limbo.domain.User;
import cn.limbo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//	@Autowired
//	private CacheManager cacheManager;

	@Autowired
	private UserService userService;

	@Test
	public void test(){
		long a = 1;
		User u1 = userService.findUserById(a);
		System.out.println("第一次查询：" + u1);

		User u2 = userService.findUserById(a);
		System.out.println("第二次查询： "+ u2);

		u1.setDescription("I Love ghy");
		userService.updateUser(u1);
		User u3 = userService.findUserById(a);
		System.out.println("第三次查询："+ u3);
	}

}
