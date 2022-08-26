package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductDTO;
import com.dh.proyecto.integrador.model.entity.ProductEntity;
import com.dh.proyecto.integrador.model.repository.IProductRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductFeatureService productFeatureService;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<ProductDTO> findAll() {

        return mapperUtil.mapAll(productRepository.findAll(), ProductDTO.class);
    }

    @Override
    public ProductDTO findById(Long id) {

        return mapperUtil.map(productRepository.findById(id), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findByCategory(Long categoryId) {
        return mapperUtil.mapAll(productRepository.findByCategory(categoryId), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findByPolicy(Long policyId) {
        return mapperUtil.mapAll(productRepository.findByPolicy(policyId), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findByCity(Long cityId) {
        return mapperUtil.mapAll(productRepository.findByCity(cityId), ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        ProductEntity p = productRepository.save(mapperUtil.map(product, ProductEntity.class));
        return mapperUtil.map(p, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO product, Long id) {
        ProductEntity productUpdated = productRepository.findById(id).orElse(null);
        if(productUpdated == null){
            // error
        }
        ProductEntity productNewData = mapperUtil.map(product,ProductEntity.class);
        productUpdated.setCategory(productNewData.getCategory());
        productUpdated.setDescription(productNewData.getDescription());
        productUpdated.setCity(productNewData.getCity());
        productUpdated.setPolicy(productNewData.getPolicy());
        productUpdated.setImage(productNewData.getImage());
        productUpdated.setName(productNewData.getName());
        productUpdated.setPolicy(productNewData.getPolicy());
        return mapperUtil.map(productRepository.save(productUpdated), ProductDTO.class);
    }

    @Override
    public ProductDTO delete(Long id) {
        ProductDTO productDeleted = mapperUtil.map(productRepository.findById(id), ProductDTO.class);
        productRepository.delete(mapperUtil.map(productDeleted, ProductEntity.class));
        return productDeleted;
    }
}
