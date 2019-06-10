package com.akhambir.dao;

import com.akhambir.model.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @EntityGraph("Category.products")
    Optional<Category> getById(Long id);

}
