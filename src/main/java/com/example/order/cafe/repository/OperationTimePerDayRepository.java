package com.example.order.cafe.repository;

import com.example.order.cafe.domain.OperationTimePerDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTimePerDayRepository extends JpaRepository<OperationTimePerDay, Long> {

}
