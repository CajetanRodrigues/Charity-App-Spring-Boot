package com.meeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Days;
import com.meeting.model.Income;
import com.meeting.model.PerDayExpense;
import com.meeting.model.PerDayExpenseFinal;
import com.meeting.repository.DayRepository;
import com.meeting.repository.IncomeRepository;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping(value="/rest")
public class DayController {
	
	 @Autowired
	 private DayRepository dayRepository;
	 
	 @Autowired
	 private IncomeRepository incomeRepository;

	 @RequestMapping(value = "/post-day-expense", method = RequestMethod.POST)
		public Days postDayExpense(@RequestBody Days day) {
//		 	Month m = new Month();
//		 	m.setMonth_exp_list(dayRepository.findAll());
//		 	monthRepository.save(m);

			return dayRepository.save(day);// return a object
		}
		
		@RequestMapping(value = "/get-day-expense", method = RequestMethod.GET)
		public List<Days> getdayExpenses() {
			return dayRepository.findAll(); // returns an arraylist
		}
		
		 @RequestMapping(value = "/get-month-expense/{month}", method = RequestMethod.GET)
		 public List<Days> getMonthExpense(@PathVariable("month") int month){
			// use the day list and send the lists with 
			 ArrayList<Days> list = new ArrayList<>();
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 month = (int)month;
			 list = dayRepository.getMonthExpenseList(month);
			 
			System.out.println(list);
			return list;
			 
		 }		
		 @RequestMapping(value = "/get-all-month-expense-amount", method = RequestMethod.GET)
		 public List<Double> getAllMonthMonthExpense(){
			// use the day list and send the lists with 
			 ArrayList<Double> list = new ArrayList<>();
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 list = dayRepository.getMonthAllMyExpenseListAmount();
			System.out.println(list);
			return list;
			 
		 }		
		 @RequestMapping(value = "/get-year-expense/{year}", method = RequestMethod.GET)
		 public List<Days> getYearExpense(@PathVariable("year") int year){
			// use the day list and send the lists with 
			 ArrayList<Days> list = new ArrayList<>();
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 year = (int)year;
			 list = dayRepository.getYearExpenseList(year);
			System.out.println(list);
			return list;
			 
		 }
		 @RequestMapping(value = "/get-total-day-expense/{day}", method = RequestMethod.GET)
		 public int getTotalDayExpense(@PathVariable("day") int day){
			// use the day list and send the lists with 
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 day = (int)day;
			 System.out.println(dayRepository.getTotalDayExpenseAmount(day));
			 int amount = (int)dayRepository.getTotalDayExpenseAmount(day);
			return amount;
			 
		 }
		 @RequestMapping(value = "/get-total-month-expense/{month}", method = RequestMethod.GET)
		 public int getTotalMonthExpense(@PathVariable("month") int month){
			// use the day list and send the lists with 
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 month = (int)month;
			 System.out.println(dayRepository.getTotalMonthExpenseAmount(month));
			 int amount = (int)dayRepository.getTotalMonthExpenseAmount(month);
			return amount;
			 
		 }
		 @RequestMapping(value = "/get-total-year-expense/{year}", method = RequestMethod.GET)
		 public int getTotalYearExpense(@PathVariable("year") int year){
			// use the day list and send the lists with 
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
			 year = (int)year;
			 System.out.println(dayRepository.getTotalYearExpenseAmount(year));
			 int amount = (int)dayRepository.getTotalYearExpenseAmount(year);
			return amount;
			 
		 }
		 @RequestMapping(value = "/get-past-four-days-expense-amount", method = RequestMethod.GET)
		 public double getPastFourDaysExpense(){

			// use the day list and send the lists with 
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
//			 year = (int)year;
//			 System.out.println(dayRepository.getTotalYearExpenseAmount(year));
			 double amount  = dayRepository.getPastFourtDaysAmount();
//			 list.add(dayRepository.getPastFourtDaysAmount());
			return amount;
		 }
		 @RequestMapping(value = "/get-past-seven-days-expense-amount", method = RequestMethod.GET)
		 public double getPastSevenDaysExpense(){

			// use the day list and send the lists with 
//			 list = dayRepository.findMonthData(month);
//			 Month m = new Month();
//			 year = (int)year;
//			 System.out.println(dayRepository.getTotalYearExpenseAmount(year));
			 double amount  = dayRepository.getPastSevenDaysAmount();
//			 list.add(dayRepository.getPastFourtDaysAmount());
			return amount;
		 }
//		 @RequestMapping(value = "/post-income-and-generate-planning", method = RequestMethod.POST)
//			public Days postIncomeAndGeneratePlanning(@PathVariable("income") int income) {
////			 	Month m = new Month();
////			 	m.setMonth_exp_list(dayRepository.findAll());
////			 	monthRepository.save(m);
//				return dayRepository.save(day);// return a object
//			}
		 
//		 
	
		 @RequestMapping(value = "/get-day-wise-data-expenses", method = RequestMethod.GET)
			public ArrayList getDayWiseData() {
			 
//			 PerDayExpenseFinal f = new PerDayExpenseFinal();
//			 PerDayExpense e = new PerDayExpense();
			 	// create a each Day array for each data
			 // with each Day [0] = [{}]
			 // each Day [1] = [{ }]
			  ArrayList<Days[]> eachDay = new ArrayList<Days[]>();
			 
			 	for(int i=1;i<=31;i++) {
			 		 Days[] data =  getDayWiseData(i);
			 		 // fetch the list wrt to each Day
			 		 eachDay.add(data);
			 	}
			 	// get  list wrt to month
			 	
			return eachDay;
//			 	Month m = new Month();
//			 	m.setMonth_exp_list(dayRepository.findAll());
//			 	monthRepository.save(m);
			 
//				return dayRepository.save();// return a object
			}
		 @RequestMapping(value = "/get-day-wise-data", method = RequestMethod.GET)
			public Days[] getDayWiseData(@PathVariable("day_no") int day_no) {
//			 	Month m = new Month();
//			 	m.setMonth_exp_list(dayRepository.findAll());
//			 	monthRepository.save(m);
				return dayRepository.getLisOfExpensesPerDay(day_no);// return a object
			}


}
