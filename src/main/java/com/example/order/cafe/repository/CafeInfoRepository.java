package com.example.order.cafe.repository;

import com.example.order.cafe.domain.CafeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeInfoRepository extends JpaRepository<CafeInfo, Long> {

}
