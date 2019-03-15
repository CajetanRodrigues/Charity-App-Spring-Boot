package com.meeting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private double income;
	
	private boolean clothing;
	private boolean education;
	private boolean food;
	private boolean groceries;
	private boolean transport;
	private boolean personal_care;
	private boolean extras;
	private boolean real_estate;
	private boolean stock_marketing;
	private boolean jewellery;
	private boolean bitcoin;
	private boolean mutual_funds;
	private boolean fixed_deposits;
	
	public boolean isReal_estate() {
		return real_estate;
	}
	public void setReal_estate(boolean real_estate) {
		this.real_estate = real_estate;
	}
	public boolean isStock_marketing() {
		return stock_marketing;
	}
	public void setStock_marketing(boolean stock_marketing) {
		this.stock_marketing = stock_marketing;
	}
	public boolean isJewellery() {
		return jewellery;
	}
	public void setJewellery(boolean jewellery) {
		this.jewellery = jewellery;
	}
	public boolean isBitcoin() {
		return bitcoin;
	}
	public void setBitcoin(boolean bitcoin) {
		this.bitcoin = bitcoin;
	}
	public boolean isMutual_funds() {
		return mutual_funds;
	}
	public void setMutual_funds(boolean mutual_funds) {
		this.mutual_funds = mutual_funds;
	}
	public boolean isFixed_deposits() {
		return fixed_deposits;
	}
	public void setFixed_deposits(boolean fixed_deposits) {
		this.fixed_deposits = fixed_deposits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public boolean isClothing() {
		return clothing;
	}
	public void setClothing(boolean clothing) {
		this.clothing = clothing;
	}
	public boolean isEducation() {
		return education;
	}
	public void setEducation(boolean education) {
		this.education = education;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isGroceries() {
		return groceries;
	}
	public void setGroceries(boolean groceries) {
		this.groceries = groceries;
	}
	public boolean isTransport() {
		return transport;
	}
	public void setTransport(boolean transport) {
		this.transport = transport;
	}

	public boolean isPersonal_care() {
		return personal_care;
	}
	public void setPersonal_care(boolean personal_care) {
		this.personal_care = personal_care;
	}
	public boolean isExtras() {
		return extras;
	}
	public void setExtras(boolean extras) {
		this.extras = extras;
	}
	
	
}
