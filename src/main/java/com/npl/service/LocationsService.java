package com.npl.service;

import com.npl.Dto.DistrictDto;
import com.npl.Dto.MunicipalityDto;
import com.npl.Dto.ProvinceDto;

import java.util.List;

public interface LocationsService {
	
	public List<ProvinceDto> getAllProvince();
	
	public List<DistrictDto> getDistrictByProvinceId(Long provinceId);
	
	List<MunicipalityDto> getMunicipalityByDistrictId(Long districtId);
}
