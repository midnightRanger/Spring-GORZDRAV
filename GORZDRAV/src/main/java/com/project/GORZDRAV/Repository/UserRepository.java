package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findByUsernameContains(String name);
    public User findByUsername(String username);
}
