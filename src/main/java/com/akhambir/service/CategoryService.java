package com.akhambir.service;

import com.akhambir.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<Category>> getAll();

}
