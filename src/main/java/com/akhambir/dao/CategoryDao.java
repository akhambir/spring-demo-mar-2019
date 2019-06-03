package com.akhambir.dao;

import com.akhambir.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    Optional<List<Category>> getAll();

    Optional<Category> create(Category category);

    Optional<Category> getById(Long id);

    Optional<Category> update(Category category);
}
