package com.sidehustle.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="U_ID")
	private int u_id;
	
	@NotEmpty
	@Column(name="U_USERNAME")
	private String u_username;
	
	@NotEmpty
	@Column(name="U_FN")
	private String u_fn;
	
	@NotEmpty
	@Column(name="U_LN")
	private String u_ln;
	
	@NotEmpty
	@Column(name="U_PASSWORD")
	private String u_password;
	
	@OneToMany(mappedBy = "user")
	private Set<Task> tasks;
	
	@OneToMany(mappedBy = "user")
	private Set<Bid> bids;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_fn=" + u_fn + ", u_ln=" + u_ln
				+ ", u_password=" + u_password + "]";
	}



	public int getU_id() {
		return u_id;
	}



	public void setU_id(int u_id) {
		this.u_id = u_id;
	}



	public String getU_username() {
		return u_username;
	}



	public void setU_username(String u_username) {
		this.u_username = u_username;
	}



	public String getU_fn() {
		return u_fn;
	}



	public void setU_fn(String u_fn) {
		this.u_fn = u_fn;
	}



	public String getU_ln() {
		return u_ln;
	}



	public void setU_ln(String u_ln) {
		this.u_ln = u_ln;
	}



	public String getU_password() {
		return u_password;
	}



	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

}


