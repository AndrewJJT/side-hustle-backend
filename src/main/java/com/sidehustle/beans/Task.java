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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TID")
	private int tid;
	
	@Column(name="TTITLE")
	private String ttitle;
	
	@Column(name="TDESC")
	private String tdesc;
	
	@Column(name="TSTREET")
	private String tstreet;
	
	@Column(name = "TCITY")
	private String tcity;
	
	@Column(name="TSTATE")
	private String tstate;
	
	@Column(name="TPRICE")
	private double tprice;
	
	@Column(name="TDURATION")
	private double tduration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UID")
	@JsonBackReference(value = "user-tasks")
	private User user;
	
	@OneToMany(mappedBy = "task")
	@JsonManagedReference(value = "task-bids")
	private Set<Bid> bids;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTtitle() {
		return ttitle;
	}


	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}


	public String getTdesc() {
		return tdesc;
	}


	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}


	public String getTstreet() {
		return tstreet;
	}


	public void setTstreet(String tstreet) {
		this.tstreet = tstreet;
	}


	public String getTcity() {
		return tcity;
	}


	public void setTcity(String tcity) {
		this.tcity = tcity;
	}


	public String getTstate() {
		return tstate;
	}


	public void setTstate(String tstate) {
		this.tstate = tstate;
	}


	public double getTprice() {
		return tprice;
	}


	public void setTprice(double tprice) {
		this.tprice = tprice;
	}


	public double getTduration() {
		return tduration;
	}


	public void setTduration(double tduration) {
		this.tduration = tduration;
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
		return "Task [tid=" + tid + ", ttitle=" + ttitle + ", tdesc=" + tdesc + ", tstreet=" + tstreet
				+ ", tcity=" + tcity + ", tstate=" + tstate + ", tprice=" + tprice + ", tduration=" + tduration
				+ ", user=" + user + "]";
	}


	
	

}
