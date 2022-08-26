package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.FeatureDTO;
import com.dh.proyecto.integrador.model.entity.FeatureEntity;
import com.dh.proyecto.integrador.model.repository.IFeatureRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements IFeatureService {

    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<FeatureDTO> findAll() {
        return mapperUtil.mapAll(featureRepository.findAll(), FeatureDTO.class);
    }

    @Override
    public FeatureDTO findById(Long id) {
        return mapperUtil.map(featureRepository.findById(id), FeatureDTO.class);
    }

    @Override
    public FeatureDTO save(FeatureDTO feature) {
        return mapperUtil.map(featureRepository.save(mapperUtil.map(feature, FeatureEntity.class)), FeatureDTO.class);
    }

    @Override
    public FeatureDTO update(FeatureDTO feature, Long id) {
        FeatureEntity featureUpdated = featureRepository.findById(id).orElse(null);
        if (featureUpdated == null) {
            // error
        }
        featureUpdated.setName(feature.getName());
        featureUpdated.setType(feature.getType());
        return mapperUtil.map(featureRepository.save(featureUpdated), FeatureDTO.class);
    }

    @Override
    public FeatureDTO delete(Long id) {
        FeatureDTO policyDeleted = mapperUtil.map(featureRepository.findById(id), FeatureDTO.class);
        featureRepository.delete(mapperUtil.map(policyDeleted, FeatureEntity.class));
        return policyDeleted;
    }

}
