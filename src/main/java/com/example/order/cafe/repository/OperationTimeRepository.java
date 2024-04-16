package com.example.order.cafe.repository;

import com.example.order.cafe.domain.OperationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTimeRepository extends JpaRepository<OperationTime, Long> {

}
