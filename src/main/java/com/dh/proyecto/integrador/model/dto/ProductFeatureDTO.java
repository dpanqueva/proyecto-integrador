package com.dh.proyecto.integrador.model.dto;

import com.dh.proyecto.integrador.model.entity.FeatureEntity;
import com.dh.proyecto.integrador.model.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeatureDTO {

    private Long id;

    /**
     * Relaciones
     */
    private ProductDTO product;

    private FeatureDTO feature;
}
