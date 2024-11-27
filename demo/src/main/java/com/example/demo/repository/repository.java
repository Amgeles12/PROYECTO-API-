package com.example.demo.repository;

import com.example.demo.entity.ProductosAAA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dto extends JpaRepository< d, Long> {
}
