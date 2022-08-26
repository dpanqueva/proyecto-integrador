package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.ProductDTO;
import com.dh.proyecto.integrador.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductDTO product) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.save(product));
        return ResponseEntity.created(URI.create("/api/v1/product")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductDTO product, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.update(product, id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Map<String, Object>> findByCategory(@PathVariable Long categoryId) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findByCategory(categoryId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/policy/{policyId}")
    public ResponseEntity<Map<String, Object>> findByPolicy(@PathVariable Long policyId) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findByPolicy(policyId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<Map<String, Object>> findByCity(@PathVariable Long cityId) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findByCity(cityId));
        return ResponseEntity.ok(response);
    }
}
