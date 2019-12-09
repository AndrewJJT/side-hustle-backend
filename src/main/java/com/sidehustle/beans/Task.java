package com.sidehustle.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T_ID")
	private int t_id;
	
	@Column(name="T_TITLE")
	private String t_title;
	
	@Column(name="T_DESC")
	private String t_desc;
	
	@Column(name="T_STREET")
	private String t_street;
	
	@Column(name = "T_CITY")
	private String t_city;
	
	@Column(name="T_STATE")
	private String t_state;
	
	@Column(name="T_PRICE")
	private double t_price;
	
	@Column(name="T_DURATION")
	private double t_duration;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="U_ID")
	private User user;
	
	@OneToMany(mappedBy = "task")
	private Set<Bid> bids;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getT_id() {
		return t_id;
	}


	public void setT_id(int t_id) {
		this.t_id = t_id;
	}


	public String getT_title() {
		return t_title;
	}


	public void setT_title(String t_title) {
		this.t_title = t_title;
	}


	public String getT_desc() {
		return t_desc;
	}


	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}


	public String getT_street() {
		return t_street;
	}


	public void setT_street(String t_street) {
		this.t_street = t_street;
	}


	public String getT_city() {
		return t_city;
	}


	public void setT_city(String t_city) {
		this.t_city = t_city;
	}


	public String getT_state() {
		return t_state;
	}


	public void setT_state(String t_state) {
		this.t_state = t_state;
	}


	public double getT_price() {
		return t_price;
	}


	public void setT_price(double t_price) {
		this.t_price = t_price;
	}


	public double getT_duration() {
		return t_duration;
	}


	public void setT_duration(double t_duration) {
		this.t_duration = t_duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@Override
	public String toString() {
		return "Task [t_id=" + t_id + ", t_title=" + t_title + ", t_desc=" + t_desc + ", t_street=" + t_street
				+ ", t_city=" + t_city + ", t_state=" + t_state + ", t_price=" + t_price + ", t_duration=" + t_duration
				+ ", user=" + user + "]";
	}


	
	

}
