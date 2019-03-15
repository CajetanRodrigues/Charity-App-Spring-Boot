package com.meeting.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meeting.model.Charity;
import com.meeting.model.Meeting;

public interface CharityRepository extends JpaRepository<Charity, Integer>  {

	@Transactional
	@Query(value="select * from charity where id=:id", nativeQuery=true)
	Charity getTrustById(@Param("id")int id);
//	@Transactional
//	@Query(value="SELECT * FROM budget_planner ORDER BY ID DESC LIMIT 1", nativeQuery=true) // gives the latest edit
//	BudgetPlanners findTheTop();
	
	@Transactional
	@Query(value="select * from charity where category=:category", nativeQuery=true)
	List<Charity> getTrustByCategory(@Param("category")String category);
	
	
	
	@Modifying
	@Transactional
	@Query(value="update charity set funds=:funds where id=:id", nativeQuery=true)
	void addFundsToTrust(@Param("funds")String funds,@Param("id")int id);

}
