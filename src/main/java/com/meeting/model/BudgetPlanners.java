package com.meeting.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class BudgetPlanners {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String needed;
	private String wanted;
	private String savings;
	
	@Temporal(TemporalType.DATE)
	private Date request_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNeeded() {
		return needed;
	}

	public void setNeeded(String needed) {
		this.needed = needed;
	}

	public String getWanted() {
		return wanted;
	}

	public void setWanted(String wanted) {
		this.wanted = wanted;
	}

	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	

	
	
}
