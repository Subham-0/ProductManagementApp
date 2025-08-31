package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

    public Product findProductByName(String str);

    public List<Product> findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(String name, String type, String place);

    public List<Product> findByPlaceIgnoreCase(String place);

    @Query("select p from Product p where p.warranty < :year")
    public List<Product> findOutOfWarranty(@Param("year") int year);
}
