package cn.limbo;

import cn.limbo.config.UploadFileProperties;
import cn.limbo.service.UploadFileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(UploadFileProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UploadFileService service) {
		return (args) -> {
			service.deleteAll();
			service.init();
		};
	}
}
