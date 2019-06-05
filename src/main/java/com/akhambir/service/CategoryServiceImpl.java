package com.akhambir.service;

import com.akhambir.dao.CategoryRepository;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<List<Category>> getAll() {
        return Optional.of(categoryRepository.findAll());
    }

    @Override
    public Optional<Category> create(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> update(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
