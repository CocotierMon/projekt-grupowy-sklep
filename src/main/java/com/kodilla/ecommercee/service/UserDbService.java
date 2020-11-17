package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserDbService {
    UserRepository userRepository;

    Random generator = new Random(500000L);

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> blockUser(final Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            user.get().setStatus(0);
            userRepository.save(user.get());
            return user;
        }
        return Optional.empty();
    }

    public Optional<Long> generateKey(final Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Long userKey = generator.nextLong();
            user.get().setUserKey(userKey);
            userRepository.save(user.get());
            return Optional.of(userKey);
        }
        return Optional.empty();
    }
}