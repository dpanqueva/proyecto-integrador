package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.PolicyDTO;
import com.dh.proyecto.integrador.model.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/policy")
public class PolicyController {

    @Autowired
    private IPolicyService policyService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", policyService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody PolicyDTO policy) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", policyService.save(policy));
        return ResponseEntity.created(URI.create("/api/v1/policy")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody PolicyDTO policy, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", policyService.update(policy, id));
        return ResponseEntity.created(URI.create("/api/v1/policy")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", policyService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", policyService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
