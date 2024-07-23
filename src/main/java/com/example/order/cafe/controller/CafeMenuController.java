package com.example.order.cafe.controller;

import com.example.order.cafe.domain.CafeMenu;
import com.example.order.cafe.dto.request.CafeMenuCreateRequest;
import com.example.order.cafe.service.CafeMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("cafes/menus")
@Tag( name = "CafeMenu", description = "카페 메뉴 API")
@RestController
public class CafeMenuController {

    private final CafeMenuService cafeMenuService;

    @PostMapping
    @Operation(summary = "카페 메뉴 등록", description = "카페의 새로운 메뉴를 등록한다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "카페 메뉴 등록 성공"),
                    @ApiResponse(responseCode = "404", description = "카페 메뉴 등록 실패")
            })
    public ResponseEntity<CafeMenu> registerCafeMenu(@Validated @RequestBody CafeMenuCreateRequest cafeMenuCreateRequest){
        CafeMenu cafeMenu = cafeMenuService.registerCafeMenu(cafeMenuCreateRequest.getCafeId(),
                cafeMenuCreateRequest.getMenuName(),
                cafeMenuCreateRequest.getTemperatureTypeList(),
                cafeMenuCreateRequest.getMenuCategory(),
                cafeMenuCreateRequest.getExplain(),
                cafeMenuCreateRequest.getStock(),
                cafeMenuCreateRequest.getPrice());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("")
                .buildAndExpand(cafeMenu.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
