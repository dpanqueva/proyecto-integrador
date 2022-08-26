package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeatureRepository extends JpaRepository<FeatureEntity, Long> {
}
