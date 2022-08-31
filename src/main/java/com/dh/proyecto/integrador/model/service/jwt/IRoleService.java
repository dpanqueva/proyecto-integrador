package com.dh.proyecto.integrador.model.service.jwt;

import com.dh.proyecto.integrador.model.dto.jwt.RoleDTO;

import java.util.List;

public interface IRoleService {


    public List<RoleDTO> findAll();

    public RoleDTO findById(Long id);

    public RoleDTO save(RoleDTO role);

    public RoleDTO update(RoleDTO role, Long id);

    public RoleDTO delete(Long id);
}
