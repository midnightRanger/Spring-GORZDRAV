package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.User;
import com.project.GORZDRAV.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void delete(User userObj) {
        userRepository.delete(userObj);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User userObj) {
        return userRepository.save(userObj);
    }

    public Iterable<User> findAll () {
        return userRepository.findAll();
    }

    public List<User> findByUsernameContains(String keyword) {
        return userRepository.findByUsernameContains(keyword);
    }

    public User findByUsername(String username) {return userRepository.findByUsername(username); }
}

