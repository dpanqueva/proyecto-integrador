package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.ProductFeatureDTO;
import com.dh.proyecto.integrador.model.service.IProductFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product-feature")
public class ProductFeatureController {

    @Autowired
    private IProductFeatureService productFeatureService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",productFeatureService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductFeatureDTO productFeature){
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",productFeatureService.save(productFeature));
        return ResponseEntity.created(URI.create("/api/v1/product-feature")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductFeatureDTO productFeature, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",productFeatureService.update(productFeature, id));
        return ResponseEntity.created(URI.create("/api/v1/product-feature")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productFeatureService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productFeatureService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
