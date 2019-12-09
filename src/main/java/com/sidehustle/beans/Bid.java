package com.sidehustle.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BID")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="B_ID")
	private int b_id;
	
	@Column(name="B_TITLE")
	private String b_title;
	
	@Column(name="B_DESC")
	private String b_desc;
	
	@Column(name="B_PRICE")
	private double b_price;
	
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
	@JoinColumn(name="U_ID")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="T_ID")
	private Task task;
	
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Bid [b_id=" + b_id + ", b_title=" + b_title + ", b_desc=" + b_desc + ", b_price=" + b_price + "]";
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_desc() {
		return b_desc;
	}
	public void setB_desc(String b_desc) {
		this.b_desc = b_desc;
	}
	public double getB_price() {
		return b_price;
	}
	public void setB_price(double b_price) {
		this.b_price = b_price;
	}

	
}


