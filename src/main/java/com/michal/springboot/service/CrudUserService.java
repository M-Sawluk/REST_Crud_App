package com.michal.springboot.service;


import com.michal.springboot.domain.User;
import com.michal.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2017-03-09.
 */
@Service
public class CrudUserService {


    private UserRepository userRepository;

    @Autowired
    public CrudUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(long id) {
        return userRepository.findOne(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.delete(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> getPages(int x, int y) {

        List<User> users = new ArrayList<>();
        userRepository.findAll(new PageRequest(x, y)).forEach(users::add);

        return users;
    }
}
