package com.akhambir.service;

import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    @Qualifier("categoryDao1")
    private CategoryDao categoryDao;

    @Override
    public Optional<List<Category>> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Optional<Category> create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryDao.getById(id);
    }

    @Override
    public Optional<Category> update(Category category) {
        return categoryDao.update(category);
    }
}
