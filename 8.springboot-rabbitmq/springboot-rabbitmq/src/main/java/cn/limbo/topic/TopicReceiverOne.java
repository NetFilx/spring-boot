package cn.limbo.topic;

import cn.limbo.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by limbo on 2017/4/29.
 */

@Component
@RabbitListener(queues = TopicRabbitConfig.TOPIC_ONE)
public class TopicReceiverOne {

	@RabbitHandler
	public void process(String message){
		System.out.println("Topic ReceiverOne  : " + message);
	}

}
