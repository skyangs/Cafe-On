package com.example.order.cafe.service;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.dto.request.CafeCreateRequest;
import com.example.order.cafe.dto.request.CafeUpdateRequest;
import com.example.order.cafe.dto.response.CafeResponse;
import com.example.order.cafe.mapper.CafeMapper;
import com.example.order.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    public CafeResponse getCafeById(long cafeId){

        Cafe cafe = check_existCafe(cafeId);

        return CafeMapper.INSTANCE.toCafeResponse(cafe);
    }

    public List<CafeResponse> getAllCafe(){

        return cafeRepository.findAll()
                .stream()
                .map(CafeMapper.INSTANCE::toCafeResponse)
                .toList();
    }

    @Transactional
    public Cafe registerCafe(CafeCreateRequest cafeCreateRequest) {

        Cafe cafe = CafeMapper.INSTANCE.toCafe(cafeCreateRequest);

        return cafeRepository.save(cafe);

    }

    @Transactional
    public void updateCafe(long cafeId, CafeUpdateRequest cafeUpdateRequest) {

        check_existCafe(cafeId);

        Cafe updateCafe = CafeMapper.INSTANCE.toCafe(cafeUpdateRequest);

        cafeRepository.save(updateCafe);
    }

    @Transactional
    public void deleteCafe(long cafeId){

        Cafe cafe = check_existCafe(cafeId);

        cafeRepository.delete(cafe);
    }

    public Cafe check_existCafe(long cafeId){
        return cafeRepository.findById(cafeId)
                .orElseThrow(NoSuchElementException::new);
    }

}
