package cn.limbo.domain;

/**
 * Created by limbo on 2017/4/10.
 */
public class City {

	//城市的id
	private Long id;

	//城市名字
	private String cityName;

	//描述
	private String description;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
