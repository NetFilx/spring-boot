package cn.limbo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/29.
 */

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

	@RabbitHandler
	public void process(String message){
		System.err.println("FanoutReceiverA : " + message);
	}

}
