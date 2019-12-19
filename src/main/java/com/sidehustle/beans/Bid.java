package com.sidehustle.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BID")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="BTITLE")
	private String btitle;
	
	@Column(name="BDESC")
	private String bdesc;
	
	@Column(name="BPRICE")
	private double bprice;
	
	@Column(name="BAPPROVED")
	private boolean bapproved;
	
	public boolean getBapproved() {
		return bapproved;
	}


	public void setBapproved(boolean bapproved) {
		this.bapproved = bapproved;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UID")
	@JsonBackReference(value = "user-bids")
	private User user;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TID")
	@JsonBackReference(value = "task-bids")
	private Task task;
	
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Bid [id=" + id + ", btitle=" + btitle + ", bdesc=" + bdesc + ", bprice=" + bprice + ", bapproved="
				+ bapproved + ", user=" + user + ", task=" + task + "]";
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBdesc() {
		return bdesc;
	}
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	
}


