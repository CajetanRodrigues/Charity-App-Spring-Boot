package com.meeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.BudgetPlanners;
import com.meeting.model.Income;
import com.meeting.repository.BudgetPlannerRepository;

@RestController
@RequestMapping(value="/rest")
public class BudgetPlannerController {
	 @Autowired
	 private BudgetPlannerRepository budgetPlannerRepository;
	 
	 @RequestMapping(value = "/post-budget-input", method = RequestMethod.POST)
		public BudgetPlanners postBudgetInput(@RequestBody BudgetPlanners budget) {
			return budgetPlannerRepository.save(budget);// return a object
		}
	 @RequestMapping(value = "/get-budget-inputs", method = RequestMethod.GET)
		public List<BudgetPlanners> getBudgetInputs() {
			return budgetPlannerRepository.findAll();// return a object
		}
	 
	 @RequestMapping(value = "/get-analytics/{income}", method = RequestMethod.GET)
		public ArrayList computeAnalytics(@PathVariable("income") int income) {

		 	BudgetPlanners budgetPlanners = budgetPlannerRepository.findTheTop();
		 	int needed = Integer.parseInt(budgetPlanners.getNeeded());
		 	int wanted = Integer.parseInt(budgetPlanners.getWanted());
		 	int savings = Integer.parseInt(budgetPlanners.getSavings());
		 	IncomeController i = new IncomeController();
		 	ArrayList<Income> list = (ArrayList<Income>) i.getTags();
		 	ArrayList finalList = new ArrayList<>();
		 	finalList.add(list);
		 	finalList.add(needed);
		 	finalList.add(wanted);
		 	finalList.add(savings);
		 	
		 	int auctual_savings = income - needed + wanted ;

		 	finalList.add(auctual_savings);
		 	return finalList;
		 	
		 	
		}
	
}
