package com.akhambir.service;

import com.akhambir.dao.UserRepository;
import com.akhambir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.getById(id);
    }
}
