package com.akhambir.service;

import com.akhambir.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<List<User>> getAll();

    User add(User user);

    Optional<User> getById(Long id);
}
