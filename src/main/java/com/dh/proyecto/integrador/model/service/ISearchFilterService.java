package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.ProductDTO;

import java.util.Date;
import java.util.List;

public interface ISearchFilterService {

    public List<ProductDTO> findProductByCityAndDates(Long cityId, Date feInit, Date feFin);

    public List<ProductDTO> findProductByDates(Date feInit, Date feFin);
}
