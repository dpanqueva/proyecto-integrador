package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductDTO;
import com.dh.proyecto.integrador.model.repository.IProductRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SearchFilterServiceImpl implements ISearchFilterService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<ProductDTO> findProductByCityAndDates(Long cityId, Date feInit, Date feFin) {
        return mapperUtil.mapAll(productRepository.findProductByCityAndDates(cityId, feInit, feFin), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findProductByDates(Date feInit, Date feFin) {
        return mapperUtil.mapAll(productRepository.findProductByDates(feInit, feFin), ProductDTO.class);
    }
}
