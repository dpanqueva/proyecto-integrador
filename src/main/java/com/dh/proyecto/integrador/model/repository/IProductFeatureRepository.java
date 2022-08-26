package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.ProductFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductFeatureRepository extends JpaRepository<ProductFeatureEntity, Long> {
}
