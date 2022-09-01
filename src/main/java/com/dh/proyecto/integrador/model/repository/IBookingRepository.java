package com.dh.proyecto.integrador.model.repository;

import com.dh.proyecto.integrador.model.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<BookingEntity, Long> {
}
