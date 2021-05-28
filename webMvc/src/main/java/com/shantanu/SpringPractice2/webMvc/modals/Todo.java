package com.shantanu.SpringPractice2.webMvc.modals;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Todo {
	
	int id;
	String owner;
	String desc;
	Date createdOn;
	boolean isComplete;
	
	
	public Todo() {
		super();
	}

	public Todo(int id, String owner, String desc, Date createdOn, boolean isComplete) {
		super();
		this.id = id;
		this.owner = owner;
		this.desc = desc;
		this.createdOn = createdOn;
		this.isComplete = isComplete;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	} 
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
		
		
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", owner=" + owner + ", desc=" + desc + ", createdOn=" + createdOn + ", isComplete="
				+ isComplete + "]";
	}
	
	

}
