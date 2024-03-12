package com.npl.repository;

import com.npl.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Long> {
List<District> findByProvinceId(Long provinceId);
}
