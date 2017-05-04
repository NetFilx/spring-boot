# Spring Boot 使用定时任务

## 构建工程

创建一个Springboot工程，在它的程序入口加上@EnableScheduling,开启调度任务。

```java
package cn.limbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

```

## 创建定时任务

创建一个定时任务，每过5s在控制台打印当前时间。

```java
package cn.limbo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by limbo on 2017/5/4.
 */
@Component
public class ScheduledTasks {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	@Scheduled(fixedRate = 3000)
	public void reportCurrentTime(){
		System.out.println("当前时间：" + df.format(new Date()));
	}

}
```

通过在方法上加@Scheduled注解，表明该方法是一个调度任务。

- @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
- @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
- @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
- @Scheduled(cron=” /5 “) ：通过cron表达式定义规则，什么是cro表达式，自行搜索引擎。

## 测试

启动springboot工程，控制台没过5s就打印出了当前的时间。

> 2017-04-29 17:39:37.672 INFO 677 — [pool-1-thread-1] com.forezp.task.ScheduledTasks : The time is now 17:39:37 
> 2017-04-29 17:39:42.671 INFO 677 — [pool-1-thread-1] com.forezp.task.ScheduledTasks : The time is now 17:39:42 
> 2017-04-29 17:39:47.672 INFO 677 — [pool-1-thread-1] com.forezp.task.ScheduledTasks : The time is now 17:39:47 
> 2017-04-29 17:39:52.675 INFO 677 — [pool-1-thread-1] com.forezp.task.ScheduledTasks : The time is now 17:39:52

## 总结

在springboot创建定时任务比较简单，只需2步：

- 1.在程序的入口加上@EnableScheduling注解。
- 2.在定时方法上加@Scheduled注解。