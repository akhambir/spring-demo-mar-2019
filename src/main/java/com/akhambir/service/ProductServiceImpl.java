package com.akhambir.service;

import com.akhambir.dao.ProductRepository;
import com.akhambir.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<List<Product>> getAllById(Long id) {
        return productRepository.getAllByCategory_id(id);
    }
}
