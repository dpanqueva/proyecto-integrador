package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<CityEntity, Long> {
}
