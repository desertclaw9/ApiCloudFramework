package com.nacho.api;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	 
    private String name;
    private String surname;
    private String email;
    private int phone;
    
    public User() {
    	
    }
    
	public User(String name, String surname, String email, int phone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
