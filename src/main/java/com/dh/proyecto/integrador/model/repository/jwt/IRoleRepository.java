package com.dh.proyecto.integrador.model.repository.jwt;

import com.dh.proyecto.integrador.model.entity.jwt.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
