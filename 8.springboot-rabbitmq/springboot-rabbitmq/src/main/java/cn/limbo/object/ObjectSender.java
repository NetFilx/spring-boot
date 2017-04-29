package cn.limbo.object;

import cn.limbo.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送一个实体
 * Created by limbo on 2017/4/29.
 */
@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;


	public void send(User user){
		System.err.println("Send Object" + user);
		this.rabbitTemplate.convertAndSend("object",user);
	}

}
