package com.example.order.cafe.service;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.service.dto.request.CafeCreateRequest;
import com.example.order.cafe.service.dto.request.CafeUpdateRequest;
import com.example.order.cafe.service.dto.response.CafeResponse;

import com.example.order.cafe.mapper.CafeMapper;
import com.example.order.cafe.repository.CafeRepository;
import com.example.order.cafe.repository.OperationTimePerDayRepository;
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
    private final OperationTimePerDayRepository operationTimePerDayRepository;

    private final CafeMapper cafeMapper;

    @Transactional
    public Cafe registerCafe(CafeCreateRequest cafeCreateRequest) {

        Cafe cafe = cafeMapper.toCafe(cafeCreateRequest.getCafeInfo(), cafeCreateRequest.getBusinessHours());

        Cafe savedCafe = cafeRepository.save(cafe);

        List<OperationTimePerDay> operationTimePerDayList = savedCafe.getBusinessHours().getOperationTimePerDayList();
        for (OperationTimePerDay operationTimePerDay : operationTimePerDayList) {
            operationTimePerDay.addCafe(savedCafe);
        }

        operationTimePerDayRepository.saveAll(operationTimePerDayList);

        return savedCafe;

    }

    @Transactional
    public void updateCafe(long cafeId, CafeUpdateRequest cafeUpdateRequest) {

        Cafe cafe = checkExistCafe(cafeId);

        Cafe cafe_update = cafeMapper.toCafe(cafeUpdateRequest.getCafeInfo(), cafeUpdateRequest.getBusinessHours());

        cafe.updateCafe(cafe_update.getCafeInfo(), cafe_update.getBusinessHours());

    }

    @Transactional
    public void deleteCafe(long cafeId){

        Cafe cafe = checkExistCafe(cafeId);

        cafeRepository.delete(cafe);
    }

    public CafeResponse getCafeById(long cafeId){

        Cafe cafe = checkExistCafe(cafeId);

        return cafeMapper.toCafeResponse(cafe);
    }

    public List<CafeResponse> getAllCafe(){

        return cafeRepository.findAll()
                .stream()
                .map(cafeMapper::toCafeResponse)
                .toList();
    }

    public Cafe checkExistCafe(long cafeId){
        return cafeRepository.findById(cafeId)
                .orElseThrow(NoSuchElementException::new);
    }

}
