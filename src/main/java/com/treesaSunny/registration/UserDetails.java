package com.treesaSunny.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * The Entity class containing getters and setters of the attributes of the entity 'UserDetails'
 */
@Entity
public class UserDetails {
	
	//declaring variables
	//private String id;
	
	private String firstname;
	private String lastName;

	
	
	@Id  @Column(unique = true)
	private String emailID;

	/*//parameterized constructor
	public UserDetails(String id, String firstname, String lastName, String emailID) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.emailID=emailID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


}
