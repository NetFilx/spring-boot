package cn.limbo.object;

import cn.limbo.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/29.
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

	@RabbitHandler
	public void process(User user) {
		System.err.println("Receive Object : " + user);
	}

}
