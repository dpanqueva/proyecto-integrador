package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.FeatureDTO;
import com.dh.proyecto.integrador.model.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/feature")
public class FeatureController {

    @Autowired
    private IFeatureService featureService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", featureService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody FeatureDTO feature) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", featureService.save(feature));
        return ResponseEntity.created(URI.create("/api/v1/feature")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody FeatureDTO feature, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", featureService.update(feature, id));
        return ResponseEntity.created(URI.create("/api/v1/feature")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", featureService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", featureService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
