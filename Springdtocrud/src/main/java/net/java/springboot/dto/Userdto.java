package net.java.springboot.dto;

public class Userdto {
	
	private int id;
	private String lastName;
	private String email;
	
	
	
	public Userdto(String lastName,int id, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		
		
		
		
	}
	public Userdto() {
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
