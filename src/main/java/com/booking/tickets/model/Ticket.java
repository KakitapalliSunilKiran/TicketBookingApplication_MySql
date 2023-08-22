package com.booking.tickets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	int id;
	String name;
	String email;
	String startfrom;
	String toAdd;
	public Ticket() {}
	public Ticket(int id, String name, String email, String startfrom, String toAdd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.startfrom = startfrom;
		this.toAdd = toAdd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStartfrom() {
		return startfrom;
	}
	public void setStartfrom(String startfrom) {
		this.startfrom = startfrom;
	}
	public String getToAdd() {
		return toAdd;
	}
	public void setToAdd(String toAdd) {
		this.toAdd = toAdd;
	}
	
	

}
