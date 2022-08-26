package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> findAll();

    public CategoryDTO findById(Long id);

    public CategoryDTO save(CategoryDTO category);

    public CategoryDTO update(CategoryDTO category, Long id);

    public CategoryDTO delete(Long id);
}
