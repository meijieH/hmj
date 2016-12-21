package com.hmj.obj;

/**
 * Euser entity. @author MyEclipse Persistence Tools
 */

public class Euser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String user;
	private String password;

	// Constructors

	/** default constructor */
	public Euser() {
	}

	/** full constructor */
	public Euser(String user, String password) {
		this.user = user;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}