package cn.limbo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by limbo on 2017/5/11.
 */

@ConfigurationProperties("upload")
public class UploadFileProperties {

	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
