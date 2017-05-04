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
