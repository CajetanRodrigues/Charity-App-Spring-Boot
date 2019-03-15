package com.meeting.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meeting.model.BudgetPlanners;

public interface BudgetPlannerRepository  extends JpaRepository<BudgetPlanners, Integer>  {


	@Transactional
	@Query(value="SELECT * FROM budget_planner ORDER BY ID DESC LIMIT 1", nativeQuery=true) // gives the latest edit
	BudgetPlanners findTheTop();

}
