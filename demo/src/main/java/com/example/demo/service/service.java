package com.example.demo.service;

import com.example.demo.dto.ProductosAAADTO;
import com.example.demo.entity.ProductosAAA;
import com.example.demo.repository.ProductosAAARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosAAAService {
    @Autowired
    private ProductosAAARepository service;

    public ProductosAAA crearProducto(ProductosAAADTO dto) {
        ProductosAAA producto = new ProductosAAA();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidad(dto.getCantidad());
        return repository.save(producto);
    }

    public Optional<ProductosAAA> obtenerProducto(Long id) {
        return repository.findById(id);
    }

    public List<ProductosAAA> obtenerTodos() {
        return repository.findAll();
    }

    public ProductosAAA actualizarProducto(Long id, ProductosAAADTO dto) {
        ProductosAAA producto = repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidad(dto.getCantidad());
        return repository.save(producto);
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}