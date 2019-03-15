package com.meeting.model;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PerDayExpenseFinal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private ArrayList<PerDayExpense> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<PerDayExpense> getList() {
		return list;
	}

	public void setList(ArrayList<PerDayExpense> list) {
		this.list = list;
	}
	
}
