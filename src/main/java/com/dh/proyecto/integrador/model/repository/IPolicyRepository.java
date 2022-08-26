package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPolicyRepository extends JpaRepository<PolicyEntity,Long> {
}
