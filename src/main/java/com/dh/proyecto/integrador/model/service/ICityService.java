package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.CategoryDTO;
import com.dh.proyecto.integrador.model.dto.CityDTO;

import java.util.List;

public interface ICityService {

    public List<CityDTO> findAll();

    public CityDTO findById(Long id);

    public CityDTO save(CityDTO city);

    public CityDTO update(CityDTO city, Long id);

    public CityDTO delete(Long id);
}
