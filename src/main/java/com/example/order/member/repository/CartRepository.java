package com.example.order.member.repository;

import com.example.order.member.domain.Cart;
import com.example.order.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByMember(Member member);
}
