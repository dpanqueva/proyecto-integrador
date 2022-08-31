package com.dh.proyecto.integrador.model.dto.jwt;

import com.dh.proyecto.integrador.model.entity.jwt.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String document;

    private String email;

    private String password;

    private String name;

    private String lastName;
    // role
    private RoleEntity role;
}
