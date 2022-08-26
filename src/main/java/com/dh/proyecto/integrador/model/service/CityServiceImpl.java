package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.CityDTO;
import com.dh.proyecto.integrador.model.entity.CityEntity;
import com.dh.proyecto.integrador.model.repository.ICityRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<CityDTO> findAll() {
        return mapperUtil.mapAll(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO findById(Long id) {
        return mapperUtil.map(cityRepository.findById(id), CityDTO.class);
    }

    @Override
    public CityDTO save(CityDTO city) {
        return mapperUtil.map(cityRepository.save(mapperUtil.map(city, CityEntity.class)), CityDTO.class);
    }

    @Override
    public CityDTO update(CityDTO city, Long id) {
        CityEntity cityUpdated = cityRepository.findById(id).orElse(null);
        if (cityUpdated == null) {
            // error
        }
        cityUpdated.setName(city.getName());
        cityUpdated.setCountry(city.getCountry());
        return mapperUtil.map(cityRepository.save(cityUpdated), CityDTO.class);
    }

    @Override
    public CityDTO delete(Long id) {
        CityDTO cityDeleted = mapperUtil.map(cityRepository.findById(id), CityDTO.class);
        cityRepository.delete(mapperUtil.map(cityDeleted, CityEntity.class));
        return cityDeleted;
    }
}
