package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.BookingDTO;
import com.dh.proyecto.integrador.model.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", bookingService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody BookingDTO booking) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", bookingService.save(booking));
        return ResponseEntity.created(URI.create("/api/v1/booking")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody BookingDTO booking, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", bookingService.update(booking, id));
        return ResponseEntity.created(URI.create("/api/v1/booking")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", bookingService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", bookingService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
