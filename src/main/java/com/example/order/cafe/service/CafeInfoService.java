package com.example.order.cafe.service;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.dto.request.CafeInfoRequest;
import com.example.order.cafe.dto.response.CafeInfoResponse;
import com.example.order.cafe.mapper.CafeInfoMapper;
import com.example.order.cafe.repository.CafeInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CafeInfoService {

    private final CafeInfoRepository cafeInfoRepository;
    private final CafeInfoMapper cafeInfoMapper;

    public CafeInfoResponse getCafeInfo(long id){

        CafeInfo cafeInfo = check_existCafeInfo(id);

        return cafeInfoMapper.toCafeInfoResponse(cafeInfo);

    }
    @Transactional
    public CafeInfo registerCafeInfo(CafeInfoRequest cafeInfoRequest) {

        CafeInfo cafeInfo = CafeInfo.of(cafeInfoRequest.getName(), cafeInfoRequest.getExplain(), cafeInfoRequest.getContactNumber(), cafeInfoRequest.getAddress());

        return cafeInfoRepository.save(cafeInfo);
    }

    @Transactional
    public CafeInfo updateCafeInfo(long id, CafeInfoRequest cafeInfoRequest) {

        check_existCafeInfo(id);

        CafeInfo updateCafeInfo = CafeInfo.of(cafeInfoRequest.getName(), cafeInfoRequest.getExplain(), cafeInfoRequest.getContactNumber(), cafeInfoRequest.getAddress());

        return cafeInfoRepository.save(updateCafeInfo);
    }

    @Transactional
    public void deleteCafeInfo(long id) {

        CafeInfo cafeInfo = check_existCafeInfo(id);

        cafeInfoRepository.delete(cafeInfo);
    }

    public CafeInfo check_existCafeInfo(long cafeInfoId){

        return cafeInfoRepository.findById(cafeInfoId)
                .orElseThrow(NoSuchElementException::new);
    }

}
