package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.CategoryDTO;
import com.dh.proyecto.integrador.model.entity.CategoryEntity;
import com.dh.proyecto.integrador.model.repository.ICategoryRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<CategoryDTO> findAll() {
        return mapperUtil.mapAll(categoryRepository.findAll(), CategoryDTO.class);
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapperUtil.map(categoryRepository.findById(id), CategoryDTO.class);
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        return mapperUtil.map(categoryRepository.save(mapperUtil.map(category, CategoryEntity.class)), CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO category, Long id) {
        CategoryEntity categoryUpdated = categoryRepository.findById(id).orElse(null);
        if (categoryUpdated == null) {
            // error
        }
        categoryUpdated.setName(category.getName());
        categoryUpdated.setType(category.getType());
        return mapperUtil.map(categoryRepository.save(categoryUpdated), CategoryDTO.class);
    }

    @Override
    public CategoryDTO delete(Long id) {
        CategoryDTO categoryDeleted = mapperUtil.map(categoryRepository.findById(id), CategoryDTO.class);
        categoryRepository.delete(mapperUtil.map(categoryDeleted, CategoryEntity.class));
        return categoryDeleted;
    }
}
