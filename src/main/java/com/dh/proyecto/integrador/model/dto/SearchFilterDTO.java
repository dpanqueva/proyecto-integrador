package com.dh.proyecto.integrador.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchFilterDTO {


    private CityDTO city;

    private Date feInit;

    private Date feFin;

}
