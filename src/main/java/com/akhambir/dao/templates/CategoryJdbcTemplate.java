package com.akhambir.dao.templates;

import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<List<Category>> getAll() {
        String query = "SELECT ID, NAME, DESCRIPTION FROM CATEGORIES";
        List<Category> c = jdbcTemplate.query(query, (ResultSet rs, int n) ->
                new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3)));

        return Optional.ofNullable(c);
    }
}
