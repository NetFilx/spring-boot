package cn.limbo.domain;

import java.io.Serializable;

/**
 * Created by limbo on 2017/4/21.
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long id;

	private String name;

	private String description;

	public User() {
	}

	public User(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
