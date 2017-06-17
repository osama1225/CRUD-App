package com.crud.dtos;

/**
 * DTO object that will be used in the frontend (JSP,Tag files) and in
 * webservice calls as resource
 * 
 * @author Mohamed
 *
 */
public class ItemDTO {

	private int id;
	private String name;
	private String description;
	private String imageUrl;
	
	public ItemDTO() {
		id = -1;
		name = null;
		description = null;
		imageUrl = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
