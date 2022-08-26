package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
