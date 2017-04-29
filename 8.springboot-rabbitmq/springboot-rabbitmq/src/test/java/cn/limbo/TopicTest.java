package cn.limbo;

import cn.limbo.topic.TopicSender;
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
public class TopicTest {

	@Autowired
	private TopicSender sender;


	@Test
	public void topic_one(){
		sender.send_one();
	}

	@Test
	public void topic_two(){
		sender.send_two();
	}

}
