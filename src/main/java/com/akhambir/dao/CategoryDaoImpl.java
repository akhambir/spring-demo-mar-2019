package com.akhambir.dao;

import com.akhambir.dao.templates.CategoryJdbcTemplate;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("categoryDao1")
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryJdbcTemplate template;

    @Override
    public Optional<List<Category>> getAll() {
        return template.getAll();
    }
}
