package cn.limbo.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送者
 * Created by limbo on 2017/4/29.
 */
@Component
public class HelloSender {

	//过注入AmqpTemplate接口的实例来实现消息的发送，AmqpTemplate接口定义了一套针对AMQP协议的基础操作。
	//在Spring Boot中会根据配置来注入其具体实现。
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(){
		//产生一个字符串，并发送到名为hello的队列中。
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello",context);
	}

}
