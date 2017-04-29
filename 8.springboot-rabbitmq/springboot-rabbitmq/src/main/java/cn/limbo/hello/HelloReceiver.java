package cn.limbo.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 定义消息接受者
 * Created by limbo on 2017/4/29.
 */
@Component
//通过@RabbitListener注解定义该类对hello队列的监听
@RabbitListener(queues = "hello")
public class HelloReceiver {

	//并用@RabbitHandler注解来指定对消息的处理方法。
	//所以，该消费者实现了对hello队列的消费，消费操作为输出消息的字符串内容。
	@RabbitHandler
	public void process(String str) {
		System.out.println("Receiver : " + str);
	}

}
