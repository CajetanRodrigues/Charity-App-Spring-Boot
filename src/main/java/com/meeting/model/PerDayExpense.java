package com.meeting.model;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PerDayExpense {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int [] eachDay = new int[31];

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getEachDay() {
		return eachDay;
	}

	public void setEachDay(int[] eachDay) {
		this.eachDay = eachDay;
	}


	
}
