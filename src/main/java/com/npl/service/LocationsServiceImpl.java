package com.npl.service;

import com.npl.Dto.DistrictDto;
import com.npl.Dto.MunicipalityDto;
import com.npl.Dto.ProvinceDto;
import com.npl.exception.NoDataFound;
import com.npl.model.District;
import com.npl.model.Municipality;
import com.npl.model.Province;
import com.npl.repository.DistrictRepo;
import com.npl.repository.MunicipalityRepo;
import com.npl.repository.ProvinceRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationsServiceImpl implements LocationsService {
	
	private final ProvinceRepo provinceRepo;
	
	private final ModelMapper modelMapper;
	
	private final DistrictRepo districtRepo;
	private final MunicipalityRepo municipalityRepo;
	
	@Override
	public List<ProvinceDto> getAllProvince() {
		List<Province> provinceEntities = provinceRepo.findAll();
		return provinceEntities.stream()
				.map(province -> modelMapper.map(province, ProvinceDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<DistrictDto> getDistrictByProvinceId(Long provinceId) {
		Optional<Province> provinces = provinceRepo.findById(provinceId);
		
		if (provinces.isEmpty()) {
			throw new NoDataFound("District not found with this Province id: " + provinceId);
		}
		
		Province province = provinces.get();
		List<District> districts = districtRepo.findByProvinceId(provinceId);
		
		return districts.stream()
				.map(district -> {
					DistrictDto districtDto = modelMapper.map(district, DistrictDto.class);
					districtDto.setProvinceName(province.getName());
					return districtDto;
				})
				.collect(Collectors.toList());
	}
	
	@Override
	public List<MunicipalityDto> getMunicipalityByDistrictId(Long districtId) {
		Optional<District> districts =districtRepo.findById(districtId);
		if(districts.isEmpty()){
			throw new NoDataFound("Municipalities is not found with this district id:" +districtId);
		}
		District district= districts.get();
		List<Municipality> municipalities =municipalityRepo.findByDistrictId(districtId);
		return municipalities.stream()
				.map(municipality -> {
					MunicipalityDto municipalityDto = modelMapper.map(municipality, MunicipalityDto.class);
					municipalityDto.setDistrictName(district.getName());
					return municipalityDto;
				})
				.collect(Collectors.toList());
	}
	
}
