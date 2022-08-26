package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductFeatureDTO;
import com.dh.proyecto.integrador.model.entity.FeatureEntity;
import com.dh.proyecto.integrador.model.entity.ProductEntity;
import com.dh.proyecto.integrador.model.entity.ProductFeatureEntity;
import com.dh.proyecto.integrador.model.repository.IProductFeatureRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFeatureServiceImpl implements IProductFeatureService {

    @Autowired
    private IProductFeatureRepository productFeatureRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<ProductFeatureDTO> findAll() {
        return mapperUtil.mapAll(productFeatureRepository.findAll(), ProductFeatureDTO.class);
    }

    @Override
    public ProductFeatureDTO findById(Long id) {
        return mapperUtil.map(productFeatureRepository.findById(id), ProductFeatureDTO.class);
    }

    @Override
    public ProductFeatureDTO save(ProductFeatureDTO productFeature) {
        ProductFeatureEntity p = productFeatureRepository.save(mapperUtil.map(productFeature, ProductFeatureEntity.class));
        return mapperUtil.map(p, ProductFeatureDTO.class);
    }

    @Override
    public ProductFeatureDTO update(ProductFeatureDTO productFeature, Long id) {
        ProductFeatureEntity productUpdated = productFeatureRepository.findById(id).orElse(null);
        if (productUpdated == null) {
            // error
        }
        productUpdated.setProduct(mapperUtil.map(productFeature.getProduct(), ProductEntity.class));
        productUpdated.setFeature(mapperUtil.map(productFeature.getFeature(), FeatureEntity.class));
        return mapperUtil.map(productFeatureRepository.save(productUpdated), ProductFeatureDTO.class);
    }

    @Override
    public ProductFeatureDTO delete(Long id) {
        ProductFeatureDTO productFeatureDeleted = mapperUtil.map(productFeatureRepository.findById(id), ProductFeatureDTO.class);
        productFeatureRepository.delete(mapperUtil.map(productFeatureDeleted, ProductFeatureEntity.class));
        return productFeatureDeleted;
    }
}
