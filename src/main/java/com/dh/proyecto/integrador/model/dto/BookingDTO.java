package com.dh.proyecto.integrador.model.dto;

import com.dh.proyecto.integrador.model.dto.jwt.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {

    private Long id;

    private Date checkIn;

    private Date checkOut;

    private ProductDTO product;

    private UserDTO customer;
}
