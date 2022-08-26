package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.CityDTO;
import com.dh.proyecto.integrador.model.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", cityService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CityDTO city) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", cityService.save(city));
        return ResponseEntity.created(URI.create("/api/v1/city")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody CityDTO city, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", cityService.update(city, id));
        return ResponseEntity.created(URI.create("/api/v1/city")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", cityService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", cityService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
