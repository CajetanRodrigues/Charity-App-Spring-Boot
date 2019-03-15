package com.meeting.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meeting.model.Days;



public interface DayRepository   extends JpaRepository<Days, Integer> {
//
//	@Query("$where" : "this.bday.getMonth() === 8" )
//	ArrayList<Day> findMonthData(int month);
//	@Transactional
//	@Query(value="select * from day where ", nativeQuery=true)
//	EmailOtp checkEmailOtp(@Param("emailData")String emailData,@Param("otpData") String otpData);

	@Transactional
	@Query(value="select * from days where extract(month from date) = :month ", nativeQuery=true)
	ArrayList<Days> getMonthExpenseList(@Param("month") int month);
	
	@Transactional
	@Query(value="select * from days where extract(year from date) = :year ", nativeQuery=true)
	ArrayList<Days> getYearExpenseList(@Param("year") int year);

	@Transactional
	@Query(value="select sum(expense) from days where extract(day from date)=:day_no", nativeQuery=true)
	int getTotalDayExpenseAmount(@Param("day_no") int day_no);
	
	@Transactional
	@Query(value="select sum(expense) from days where extract(day from date)=:month_no", nativeQuery=true)
	int getTotalMonthExpenseAmount(@Param("month_no") int month_no);

	@Transactional
	@Query(value="select sum(expense) from days where extract(year from date)=:year_no", nativeQuery=true)
	int getTotalYearExpenseAmount(@Param("year_no") int year_no);

	@Transactional
	@Query(value="select sum(expense) from days group by extract(month from date)", nativeQuery=true)
	ArrayList<Double> getMonthAllMyExpenseListAmount();

	@Transactional
	@Query(value="SELECT * FROM days WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 4 DAY ) AND CURDATE( )", nativeQuery=true)
	ArrayList<Days> getPastFourDaysExpenseObjects();

	@Transactional
	@Query(value="SELECT sum(expense) FROM days WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 4 DAY ) AND CURDATE( )", nativeQuery=true)
	double getPastFourtDaysAmount();


	@Transactional
	@Query(value="SELECT sum(expense) FROM days WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE( )", nativeQuery=true)
	double getPastSevenDaysAmount();

	@Transactional
	@Query(value="select * from days where extract(day from date)= :day_no", nativeQuery=true)
	Days[] getLisOfExpensesPerDay(int day_no);
	



	

}
