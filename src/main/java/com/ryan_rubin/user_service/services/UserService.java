package com.ryan_rubin.user_service.services;

import com.ryan_rubin.user_service.models.ServiceException;
import com.ryan_rubin.user_service.models.User;
import com.ryan_rubin.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(Integer id) {
        return userRepository.findById(id);
    }

    public User create(User user) throws Exception {
        String validation = validate(user);
        if (!validation.isBlank()) {
            throw new ServiceException(validation);
        }
        return userRepository.save(user);
    }

    public Optional<User> update(Integer id, User user) throws Exception {
        String validation = validate(user);
        if (!validation.isBlank()) {
            throw new ServiceException(validation);
        }
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User userGet = userOpt.get();
            userGet.setName(user.getName());
            userGet.setEmail(user.getEmail());
            return Optional.of(userRepository.save(userGet));
        } else {
            return userOpt;
        }
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    private String validate(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            return "Name is required.";
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            return "Email is required.";
        }
        return "";
    }
}
