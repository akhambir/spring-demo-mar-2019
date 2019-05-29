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
}
