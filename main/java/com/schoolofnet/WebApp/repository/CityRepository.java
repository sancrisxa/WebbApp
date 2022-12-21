package com.schoolofnet.WebApp.repository;

import com.schoolofnet.WebApp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
