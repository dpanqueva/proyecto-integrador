package com.dh.proyecto.integrador.controller;

import com.dh.proyecto.integrador.model.dto.SearchFilterDTO;
import com.dh.proyecto.integrador.model.service.ISearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/search-filter")
public class SearchFiltersController {

    @Autowired
    private ISearchFilterService searchFilterService;


    /**
     * Recibira una fecha y ciudad para filtrar disponibilidad de productos, si los productos
     * estan reservados en las fechas y ciudad escogidas por el cliente, estos productos no se filtraran
     * o se mostraran.
     * De esta manera ya le han dado al cliente los productos disponibles para realizar la
     * respectiva reserva
     */
    @PostMapping("/city-dates")
    public ResponseEntity<Map<String, Object>> findProductByCityAndDates(@RequestBody SearchFilterDTO filter) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", searchFilterService.findProductByCityAndDates(filter.getCity().getId(), filter.getFeInit(), filter.getFeFin()));
        return ResponseEntity.ok(response);
    }

    /**
     * Recibira una fecha para filtrar disponibilidad de productos, si los productos
     * estan reservados en las fechas escogidas por el cliente, estos productos no se filtraran
     * o se mostraran.
     * De esta manera ya le han dado al cliente los productos disponibles para realizar la
     * respectiva reserva
     */
    @PostMapping("/dates")
    public ResponseEntity<Map<String, Object>> findProductByDates(@RequestBody SearchFilterDTO filter) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", searchFilterService.findProductByDates(filter.getFeInit(), filter.getFeFin()));
        return ResponseEntity.ok(response);
    }

}
