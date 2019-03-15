package com.meeting.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Month {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private ArrayList<Days> month_exp_list;
	public int getId() { 
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Days> getMonth_exp_list() {
		return month_exp_list;
	}
	public void setMonth_exp_list(List<Days> list) {
		this.month_exp_list = (ArrayList<Days>) list;
	}
	
}
