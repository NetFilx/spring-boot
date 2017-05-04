# Spring Boot 使用 JavaMail

springboot对JavaMail提供了很好的支持，对其做了起步依赖。

## 构架工程

创建一个springboot工程，在其pom文件加入：

```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
```

## 添加配置

```properties
spring.mail.host=smtp.163.com
spring.mail.username=miles02@163.com
spring.mail.password=
spring.mail.port=25
spring.mail.protocol=smtp
spring.mail.default-encoding=UTF-8
```

在password 中填写自己的邮箱密码。

## 测试发邮件

测试代码清单如下：

```java
package cn.limbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {

	@Autowired
	private JavaMailSenderImpl mailSender;

	private String from = "wyh19960405@163.com";
	private String to = "1610770854@qq.com";


	/**
	 * 发送包含简单文本的邮件
	 */
	@Test
	public void sendTxtMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//设置收件人，寄件人
		simpleMailMessage.setTo(to);
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
		simpleMailMessage.setText("这里是一段简单的文本");
		//发送邮件
		mailSender.send(simpleMailMessage);
		System.out.println("邮件已发送");
	}

	/**
	 * 发送包含HTML文本的邮件
	 *
	 * @throws Exception
	 */
	@Test
	public void sendHtmlMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
		sb.append("</html>");

		//启动html
		mimeMessageHelper.setText(sb.toString(), true);
		//发送邮件
		mailSender.send(mimeMessage);
		System.out.println("邮件已发送");
	}

	/**
	 * 发送包含内嵌图片的邮件
	 *
	 * @throws Exception
	 */
	@Test
	public void sendAttachedImageMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// multipart模式
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【图片】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
		// cid为固定写法，imageId指定一个标识
		sb.append("<img src=\"cid:imageId\"/></body>");
		sb.append("</html>");

		mimeMessageHelper.setText(sb.toString(), true);
		// 设置imageId
		FileSystemResource img = new FileSystemResource(new File("/Users/limbo/Desktop/1.jpg"));
		mimeMessageHelper.addInline("imageId",img);

		mailSender.send(mimeMessage);

		System.out.println("邮件已发送");
	}

	/**
	 * 发送包含附件的邮件
	 * @throws Exception
	 */
	@Test
	public void sendAttendedFileMail()throws Exception{

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【附件】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
		sb.append("</html>");

		mimeMessageHelper.setText(sb.toString(),true);
		FileSystemResource docx = new FileSystemResource(new File("/Users/limbo/Desktop/resume.docx"));
		mimeMessageHelper.addAttachment("resume.docx",docx);

		mailSender.send(mimeMessage);

		System.out.println("邮件已发送");
	}

}
```

# 坑点

1. 建议最开始使用163作为测试的邮件服务器，因为163使用起来最方便，如果使用qq，或者gmail之类的需要对POP3/IMAP等设置，qq还需要把你的密码替换成授权码，简单起见，使用163吧。
2. 关于退信什么的，如果你的邮件被检测成为是垃圾邮件，就会被退信啦，如果你一直测试这个程序，就会报错，因为被退信了