package com.ikh.demo.service;

import com.ikh.demo.model.User;
import com.ikh.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    final UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

    public User findById(Long id) {
        return userRepository.getById(id);
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void delete(User user) { userRepository.delete(user); }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
