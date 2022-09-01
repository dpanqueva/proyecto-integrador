package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.FavoriteDTO;

import java.util.List;

public interface IFavoriteService {

    public List<FavoriteDTO> findAll();

    public FavoriteDTO findById(Long id);

    public long countByProductAndCustomer(Long productId, Long userId);

    public FavoriteDTO save(FavoriteDTO favorite);

    public FavoriteDTO update(FavoriteDTO favorite, Long id);

    public FavoriteDTO delete(Long id);
}
