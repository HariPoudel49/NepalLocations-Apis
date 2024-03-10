package com.npl.service;

import com.npl.Dto.ProvinceDto;
import com.npl.model.Province;
import com.npl.repository.ProvinceRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationsServiceImpl implements LocationsService{
	private final ProvinceRepo provinceRepo;
	private final ModelMapper modelMapper;
	
	
	@Override
	public List<ProvinceDto> getAllProvince() {
	List<Province> provinceEntities= provinceRepo.findAll();
	return provinceEntities.stream()
			.map(province -> modelMapper.map(province, ProvinceDto.class))
			.collect(Collectors.toList());
	}
}
