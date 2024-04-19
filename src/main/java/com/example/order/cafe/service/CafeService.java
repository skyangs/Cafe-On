package com.example.order.cafe.service;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.dto.request.CafeCreateRequest;
import com.example.order.cafe.dto.request.CafeUpdateRequest;
import com.example.order.cafe.dto.response.CafeResponse;
import com.example.order.cafe.dto.response.BusinessHoursResponse;
import com.example.order.cafe.dto.response.CafeInfoResponse;
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

    private final CafeInfoService cafeInfoService;
    private final BusinessHoursService businessHoursService;

    public CafeResponse getCafeById(long cafeId){

        Cafe cafe = check_existCafe(cafeId);

        CafeInfoResponse cafeInfoResponse = cafeInfoService.getCafeInfo(cafe.getCafeInfo().getId());
        BusinessHoursResponse businessHoursResponse= businessHoursService.getBusinessHours(cafe.getBusinessHours().getId());

        return new CafeResponse(cafeInfoResponse, businessHoursResponse);
    }

    public List<CafeResponse> getAllCafe(){

        return cafeRepository.findAll()
                .stream()
                .map(cafe -> {
                    CafeInfoResponse cafeInfoResponse = cafeInfoService.getCafeInfo(cafe.getCafeInfo().getId());
                    BusinessHoursResponse businessHoursResponse= businessHoursService.getBusinessHours(cafe.getBusinessHours().getId());

                    return new CafeResponse(cafeInfoResponse, businessHoursResponse);
                })
                .toList();
    }

    @Transactional
    public void registerCafe(CafeCreateRequest cafeCreateRequest) {

        CafeInfo cafeInfo = cafeInfoService.registerCafeInfo(cafeCreateRequest.getCafeInfoRequest());
        BusinessHours businessHours = businessHoursService.registerBusinessHours(cafeCreateRequest.getBusinessHoursRequest().getOperationTimeList());

        Cafe cafe = Cafe.of(cafeInfo, businessHours);

        cafeRepository.save(cafe);
    }

    @Transactional
    public void updateCafe(long cafeId, CafeUpdateRequest cafeUpdateRequest) {

        Cafe cafe = check_existCafe(cafeId);

        CafeInfo updateCafeInfo = cafeInfoService.updateCafeInfo(cafe.getCafeInfo().getId(),cafeUpdateRequest.getCafeInfoRequest());
        BusinessHours updateBusinessHours = businessHoursService.updateBusinessHours(cafe.getBusinessHours().getId(), cafeUpdateRequest.getBusinessHoursUpdateRequest().getOperationTimePerDayUpdateRequests());

        Cafe updaeCafe = Cafe.of(updateCafeInfo, updateBusinessHours);

        cafeRepository.save(updaeCafe);
    }

    @Transactional
    public void deleteCafe(long cafeId){

        Cafe cafe = check_existCafe(cafeId);

        cafeInfoService.deleteCafeInfo(cafe.getCafeInfo().getId());
        businessHoursService.deleteBusinessHours(cafe.getBusinessHours().getId());
        cafeRepository.delete(cafe);
    }

    public Cafe check_existCafe(long cafeId){
        return cafeRepository.findById(cafeId)
                .orElseThrow(NoSuchElementException::new);
    }

}
