package cn.limbo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/29.
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

	@RabbitHandler
	public void process(String message){
		System.err.println("FanoutReceiverB : " + message);
	}

}
