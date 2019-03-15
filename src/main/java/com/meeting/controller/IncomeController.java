package com.meeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Days;
import com.meeting.model.Income;
import com.meeting.repository.IncomeRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/rest")
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;

	@RequestMapping(value = "/post-income", method = RequestMethod.POST)
	public Income postIncome(@RequestBody Income income) {
//	 	Month m = new Month();
//	 	m.setMonth_exp_list(dayRepository.findAll());
//	 	monthRepository.save(m);
		Income i = new Income();
		
		 i.setIncome(income.getIncome());
		 i.setClothing(income.isClothing());
		 i.setEducation(income.isEducation());
		 i.setFood(income.isFood());
		 i.setGroceries(income.isGroceries());
		 i.setExtras(income.isExtras());
		 i.setTransport(income.isTransport());
		 i.setPersonal_care(income.isPersonal_care());
		 i.setJewellery(income.isJewellery());
		 i.setReal_estate(income.isReal_estate());
		
		 i.setStock_marketing(income.isStock_marketing());
		 i.setJewellery(income.isJewellery());
		 i.setBitcoin(income.isBitcoin());
		 i.setMutual_funds(income.isMutual_funds());
		 i.setFixed_deposits(income.isFixed_deposits());
		return incomeRepository.save(income);// return a object
	}
	@RequestMapping(value = "/get-tags", method = RequestMethod.GET)
	public List<Income> getTags() {
//	 	Month m = new Month();
//	 	m.setMonth_exp_list(dayRepository.findAll());
//	 	monthRepository.save(m);
		return incomeRepository.findAll();// return a object
	}
	@RequestMapping(value = "/get-income-with-division", method = RequestMethod.GET)
	public List<Income> getTagsWithDivision() {
//	 	Month m = new Month();
//	 	m.setMonth_exp_list(dayRepository.findAll());
//	 	monthRepository.save(m);
		return incomeRepository.findAll();// return a object
	}
	
}
