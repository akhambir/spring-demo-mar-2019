package com.akhambir.service;

import com.akhambir.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<List<Product>> getAllById(Long id);
}
