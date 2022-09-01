package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

    public long countByProductAndCustomer(Long productId, Long userId);
}
