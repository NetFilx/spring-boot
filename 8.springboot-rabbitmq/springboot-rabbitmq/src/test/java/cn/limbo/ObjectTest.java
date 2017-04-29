package cn.limbo;

import cn.limbo.domain.User;
import cn.limbo.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by limbo on 2017/4/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

	@Autowired
	private ObjectSender sender;

	@Test
	public void send(){
		sender.send(new User(1,"wyh"));
	}

}
