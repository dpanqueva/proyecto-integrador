package com.dh.proyecto.integrador.model.repository.jwt;

import com.dh.proyecto.integrador.model.entity.jwt.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);
}
