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

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UID")
	private int uid;
	
	@NotEmpty
	@Column(name="UUSERNAME")
	private String uusername;
	
	@NotEmpty
	@Column(name="UFN")
	private String ufn;
	
	@NotEmpty
	@Column(name="ULN")
	private String uln;
	
	@NotEmpty
	@Column(name="UPASSWORD")
	private String upassword;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value = "user-tasks")
	private Set<Task> tasks;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value = "user-bids")
	private Set<Bid> bids;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uusername=" + uusername + ", ufn=" + ufn + ", uln=" + uln
				+ ", upassword=" + upassword + "]";
	}



	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public String getUusername() {
		return uusername;
	}



	public void setUusername(String uusername) {
		this.uusername = uusername;
	}



	public String getUfn() {
		return ufn;
	}



	public void setUfn(String ufn) {
		this.ufn = ufn;
	}



	public String getUln() {
		return uln;
	}



	public void setUln(String uln) {
		this.uln = uln;
	}



	public String getUpassword() {
		return upassword;
	}



	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

}


