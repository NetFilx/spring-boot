package cn.limbo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by limbo on 2017/4/7.
 */

@ConfigurationProperties(prefix = "cn.limbo")
public class ConfigBean {
	private String name;
	private String want;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWant() {
		return want;
	}

	public void setWant(String want) {
		this.want = want;
	}
}
