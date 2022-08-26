package com.dh.proyecto.integrador.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDTO {

    private Long id;


    private String name;


    private String type;

    /**
     * Relacion
     */


}
