package com.opinta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person_UUID_generated_uuid2 {
	@Id
	@GeneratedValue(generator="system-uuid")
	@Column(columnDefinition = "VARCHAR(64) NOT NULL UNIQUE")
	private String id;
	public String getId() {
	return id;
}
	public void setId(String id) {
		this.id = id;
	}

	private String name;

	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
