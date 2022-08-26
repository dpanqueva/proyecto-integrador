package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.CategoryDTO;
import com.dh.proyecto.integrador.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",categoryService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CategoryDTO category){
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",categoryService.save(category));
        return ResponseEntity.created(URI.create("/api/v1/category")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody CategoryDTO category, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta",categoryService.update(category, id));
        return ResponseEntity.created(URI.create("/api/v1/category")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", categoryService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", categoryService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
