package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity,Long> {

    public List<ProductEntity> findByCategory(Long categoryId);

    public List<ProductEntity> findByPolicy(Long policyId);

    public List<ProductEntity> findByCity(Long cityId);

}
