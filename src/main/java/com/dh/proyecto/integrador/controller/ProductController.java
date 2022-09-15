package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.ProductDTO;
import com.dh.proyecto.integrador.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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


    /**
     * Metodo para paginar la información desde base de datos sin alterar nuestras entregas,
     * el funcionamiento del metodo se basa en un número de página que inicia en 0 (es un array) y
     * un numero de datos a mostrar, page y numData, con esto nosotros usamos una interface de
     * CrudRepository que se implementa bajo un PageRequest, objeto que recibe el número de página y
     * la cantidad de datos a mostrar
     * @param page
     * @param numData
     * */
    @GetMapping("/{page}/{numData}")
    public ResponseEntity<Map<String, Object>> indexPageable(@PathVariable Integer page,@PathVariable Integer numData) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", productService.findAll(PageRequest.of(page, numData)));
        return ResponseEntity.ok(response);
    }

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
