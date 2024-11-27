package com.example.demo.controller;

import com.example.demo.dto.dto;
import com.example.demo.entity.entity;
import com.example.demo.service.ProductosAAAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class controller {

    @Autowired
    private ProductosAAAService service;

    @PostMapping
    public ResponseEntity<ProductosAAA> crearProducto(@RequestBody ProductosAAADTO dto) {
        return ResponseEntity.ok(service.crearProducto(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosAAA> obtenerProducto(@PathVariable Long id) {
        return service.obtenerProducto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductosAAA>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosAAA> actualizarProducto(@PathVariable Long id, @RequestBody ProductosAAADTO dto) {
        return ResponseEntity.ok(service.actualizarProducto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}