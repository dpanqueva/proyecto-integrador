package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductFeatureDTO;

import java.util.List;

public interface IProductFeatureService {

    public List<ProductFeatureDTO> findAll();

    public ProductFeatureDTO findById(Long id);

    public ProductFeatureDTO save(ProductFeatureDTO productFeature);

    public ProductFeatureDTO update(ProductFeatureDTO productFeature, Long id);

    public ProductFeatureDTO delete(Long id);
}
