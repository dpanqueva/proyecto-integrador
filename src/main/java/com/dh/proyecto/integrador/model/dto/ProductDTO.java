package com.dh.proyecto.integrador.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id;

    private String name;

    private String year;

    private String description;

    private CityDTO city;

    private CategoryDTO category;

    private PolicyDTO policy;

    private ImageDTO image;

    //private List<ProductFeatureDTO> features;

}
