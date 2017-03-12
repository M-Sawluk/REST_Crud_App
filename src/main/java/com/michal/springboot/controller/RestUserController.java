package com.michal.springboot.controller;

import com.michal.springboot.domain.User;
import com.michal.springboot.repository.UserInMemoryRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mike on 2017-03-09.
 */
@RestController
public class RestUserController {

    private UserInMemoryRepositoryImpl iMR = new UserInMemoryRepositoryImpl();

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return iMR.getAllUsers();
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable long id){
        return iMR.getUser(id);
    }

    @RequestMapping(value="/add" , method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        iMR.addUser(user);
    }

    @RequestMapping(value="/update/{id}" ,method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable long id){
        iMR.updateUser(id,user);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
        iMR.deleteUser(id);
    }

}
