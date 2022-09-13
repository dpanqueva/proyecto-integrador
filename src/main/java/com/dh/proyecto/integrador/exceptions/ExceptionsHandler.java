package com.dh.proyecto.integrador.exceptions;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dpanquev
 * @version 2022-09-13
 */
@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

    /**
     * Method obtain error for NotContentException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MalformedJwtException.class, UnsupportedJwtException.class, ExpiredJwtException.class
            , SignatureException.class})
    public ResponseEntity<Map<String, Object>> notContentException(Exception e) {
        log.info(e.getClass().getName());
        log.info(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", "Fail validate jwt ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    /**
     * Method obtain error for BadRequestException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class
            , MissingRequestHeaderException.class})
    public ResponseEntity<Map<String, Object>> batRequestException(Exception e) {
        log.info(e.getClass().getName());
        log.info(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", "Error, the request is dangerous ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class, RuntimeException.class,
            IOException.class, ParseException.class, SocketTimeoutException.class})
    public final ResponseEntity<Map<String, Object>> exceptionsGeneral(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", "Error, Internal server error ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
