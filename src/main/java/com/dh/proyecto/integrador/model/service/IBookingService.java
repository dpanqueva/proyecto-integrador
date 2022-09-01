package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.BookingDTO;

import java.util.List;

public interface IBookingService {

    public List<BookingDTO> findAll();

    public BookingDTO findById(Long id);

    public BookingDTO save(BookingDTO booking);

    public BookingDTO update(BookingDTO booking, Long id);

    public BookingDTO delete(Long id);
}
