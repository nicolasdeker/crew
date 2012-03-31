package com.deker.apps.crew.entity.identifier;

import java.util.Map;

public class UniqueIdentifier {

	private String name;
	private Map<String, Object> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
