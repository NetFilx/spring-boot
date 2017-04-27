package cn.limbo;

import cn.limbo.consume.UserConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by limbo on 2017/4/27.
 */
@SpringBootApplication
public class Consumer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Consumer.class,args);
		UserConsumerService service = context.getBean(UserConsumerService.class);
		service.printUser();
	}

}
