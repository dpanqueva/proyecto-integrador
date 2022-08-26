package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.FeatureDTO;
import com.dh.proyecto.integrador.model.dto.PolicyDTO;

import java.util.List;

public interface IFeatureService {

    public List<FeatureDTO> findAll();

    public FeatureDTO findById(Long id);

    public FeatureDTO save(FeatureDTO feature);

    public FeatureDTO update(FeatureDTO feature, Long id);

    public FeatureDTO delete(Long id);
}
