package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.FavoriteDTO;
import com.dh.proyecto.integrador.model.entity.FavoriteEntity;
import com.dh.proyecto.integrador.model.repository.IFavoriteRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements IFavoriteService {

    @Autowired
    private IFavoriteRepository favoriteRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<FavoriteDTO> findAll() {
        return mapperUtil.mapAll(favoriteRepository.findAll(), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO findById(Long id) {
        return mapperUtil.map(favoriteRepository.findById(id), FavoriteDTO.class);
    }

    @Override
    public long countByProductAndCustomer(Long productId, Long userId) {
        return favoriteRepository.countByProductAndCustomer(productId, userId);
    }

    @Override
    public FavoriteDTO save(FavoriteDTO favorite) {
        return mapperUtil.map(favoriteRepository.save(mapperUtil.map(favorite, FavoriteEntity.class)), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO update(FavoriteDTO favorite, Long id) {
        FavoriteEntity favoriteUpdated = favoriteRepository.findById(id).orElse(null);
        if (favoriteUpdated == null) {
            // error
        }
        FavoriteEntity favoriteNewData = mapperUtil.map(favorite, FavoriteEntity.class);
        favoriteUpdated.setCustomer(favoriteNewData.getCustomer());
        favoriteUpdated.setProduct(favoriteNewData.getProduct());
        return mapperUtil.map(favoriteRepository.save(favoriteUpdated), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO delete(Long id) {
        FavoriteDTO bookingDeleted = mapperUtil.map(favoriteRepository.findById(id), FavoriteDTO.class);
        favoriteRepository.delete(mapperUtil.map(bookingDeleted, FavoriteEntity.class));
        return bookingDeleted;
    }
}
