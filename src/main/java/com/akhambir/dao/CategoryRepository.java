package com.akhambir.dao;

import com.akhambir.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<List<Category>> getByNameAndDescriptionLike(String name, String desc);

    @Query(value = "from Category c where c.id =:id")
    Optional<Category> getCategory(Long id);

    @Query(name = "query1")
    Optional<List<Category>> getCategories();
}
