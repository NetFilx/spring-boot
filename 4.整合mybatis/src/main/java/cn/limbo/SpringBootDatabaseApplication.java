package cn.limbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//mapper 接口扫描包
@MapperScan("cn.limbo.dao")
@ComponentScan
@EnableAutoConfiguration
public class SpringBootDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatabaseApplication.class, args);
	}
}
