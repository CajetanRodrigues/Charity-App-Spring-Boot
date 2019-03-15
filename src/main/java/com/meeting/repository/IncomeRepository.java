package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meeting.model.Income;

public interface IncomeRepository  extends JpaRepository<Income, Integer>{

}
