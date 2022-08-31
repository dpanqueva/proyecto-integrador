package com.dh.proyecto.integrador.controller;


import com.dh.proyecto.integrador.model.dto.jwt.UserDTO;
import com.dh.proyecto.integrador.model.service.jwt.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", userService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody UserDTO user) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", userService.save(user));
        return ResponseEntity.created(URI.create("/api/v1/user")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody UserDTO user, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", userService.update(user, id));
        return ResponseEntity.created(URI.create("/api/v1/user")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", userService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", userService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
