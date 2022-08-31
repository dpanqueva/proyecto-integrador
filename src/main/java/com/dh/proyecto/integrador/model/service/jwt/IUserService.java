package com.dh.proyecto.integrador.model.service.jwt;

import com.dh.proyecto.integrador.model.dto.jwt.UserDTO;

import java.util.List;

public interface IUserService {

    public UserDTO findByEmail(String email);

    public List<UserDTO> findAll();

    public UserDTO findById(Long id);

    public UserDTO save(UserDTO user);

    public UserDTO update(UserDTO user, Long id);

    public UserDTO delete(Long id);
}
