package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    public List<ProductDTO> findAll();

    public ProductDTO findById(Long id);

    public List<ProductDTO> findByCategory(Long categoryId);

    public List<ProductDTO> findByPolicy(Long policyId);

    public List<ProductDTO> findByCity(Long cityId);

    public ProductDTO save(ProductDTO product);

    public ProductDTO update(ProductDTO product, Long id);

    public ProductDTO delete(Long id);
}
