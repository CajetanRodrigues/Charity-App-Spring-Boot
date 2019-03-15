package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meeting.model.Month;



@Repository
public interface MonthRepository   extends JpaRepository<Month, Integer>  {

}
