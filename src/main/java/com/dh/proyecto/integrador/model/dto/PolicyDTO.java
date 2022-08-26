package com.dh.proyecto.integrador.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDTO {

    private Long id;

    private String name;

    private String description;

    private Float invoice;


}
