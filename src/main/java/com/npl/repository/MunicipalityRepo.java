package com.npl.repository;

import com.npl.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityRepo extends JpaRepository<Municipality, Long> {
	List<Municipality> findByDistrictId(Long districtId);
}
