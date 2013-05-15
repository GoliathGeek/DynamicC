package org.geek.dynamicc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Unit implements Serializable {
	private String id;
	private String name;
	// 连接符
	private int link;

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public Unit(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
