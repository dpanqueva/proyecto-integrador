package com.dh.proyecto.integrador.model.service;

import com.dh.proyecto.integrador.model.dto.BookingDTO;
import com.dh.proyecto.integrador.model.entity.BookingEntity;
import com.dh.proyecto.integrador.model.repository.IBookingRepository;
import com.dh.proyecto.integrador.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<BookingDTO> findAll() {
        return mapperUtil.mapAll(bookingRepository.findAll(), BookingDTO.class);
    }

    @Override
    public BookingDTO findById(Long id) {
        return mapperUtil.map(bookingRepository.findById(id), BookingDTO.class);
    }

    @Override
    public BookingDTO save(BookingDTO booking) {
        return mapperUtil.map(bookingRepository.save(mapperUtil.map(booking, BookingEntity.class)), BookingDTO.class);
    }

    @Override
    public BookingDTO update(BookingDTO booking, Long id) {
        BookingEntity bookingUpdated = bookingRepository.findById(id).orElse(null);
        if (bookingUpdated == null) {
            // error
        }
        BookingEntity bookingNewData = mapperUtil.map(booking, BookingEntity.class);
        bookingUpdated.setCheckIn(bookingNewData.getCheckIn());
        bookingUpdated.setCheckOut(bookingNewData.getCheckOut());
        bookingUpdated.setCustomer(bookingNewData.getCustomer());
        bookingUpdated.setProduct(bookingNewData.getProduct());
        return mapperUtil.map(bookingRepository.save(bookingUpdated), BookingDTO.class);
    }

    @Override
    public BookingDTO delete(Long id) {
        BookingDTO bookingDeleted = mapperUtil.map(bookingRepository.findById(id), BookingDTO.class);
        bookingRepository.delete(mapperUtil.map(bookingDeleted, BookingEntity.class));
        return bookingDeleted;
    }
}
