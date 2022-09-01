package com.dh.proyecto.integrador.model.dto;

import com.dh.proyecto.integrador.model.dto.jwt.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteDTO {

    private Long id;

    private ProductDTO product;

    private UserDTO customer;
}
