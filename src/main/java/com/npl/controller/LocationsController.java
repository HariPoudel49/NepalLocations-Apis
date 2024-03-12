package com.npl.controller;

import com.npl.Dto.DistrictDto;
import com.npl.Dto.ProvinceDto;
import com.npl.service.LocationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/locations")

public class LocationsController {
private final LocationsService locationsService;
	
	@GetMapping("/provinces")
	public ResponseEntity<List<ProvinceDto>> getAllProvince() {
		List<ProvinceDto> provinces = locationsService.getAllProvince();
		return new ResponseEntity<>(provinces, HttpStatus.OK);
	}
	
	@GetMapping("/districts/{provinceId}")
	public ResponseEntity<List<DistrictDto>> getDistrict(@PathVariable Long provinceId){
		List<DistrictDto>district= locationsService.getDistrictByProvinceId(provinceId);
		return new ResponseEntity<>(district, HttpStatus.FOUND);
	}

}
