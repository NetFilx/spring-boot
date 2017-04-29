package cn.limbo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by limbo on 2017/4/29.
 */

@Configuration
public class RabbitConfig {

	//创建RabbitMQ的配置类RabbitConfig，用来配置队列、交换器、路由等高级信息。
	@Bean
	public Queue helloQueue(){
		return new Queue("hello");
	}

	@Bean
	public Queue objectQueue() {
		return new Queue("object");
	}

}
