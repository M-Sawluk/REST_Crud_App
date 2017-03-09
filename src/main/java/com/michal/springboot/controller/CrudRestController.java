package com.michal.springboot.controller;

import com.michal.springboot.domain.Address;
import com.michal.springboot.domain.User;
import com.michal.springboot.service.CrudAddressService;
import com.michal.springboot.service.CrudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Mike on 2017-03-09.
 */

@RestController
public class CrudRestController {

    @Autowired
    private CrudUserService crudUserService;

    @Autowired
    private CrudAddressService crudAddressService;

    @RequestMapping("/getUsers")
    public List<User> getUserList(){
        return crudUserService.getAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        crudUserService.addUser(user);
    }

    @RequestMapping(value="/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
        crudUserService.deleteUser(id);
    }

    @RequestMapping(value="/getUser/{id}")
    public User getUser(@PathVariable long id){
        return crudUserService.getUser(id);
    }

    @RequestMapping(value = "/addAddress/{userId}", method = RequestMethod.POST)
    public void addAddress(@RequestBody Address address, @PathVariable long userId) {
        address.setUser(new User(userId,"",""));
        crudAddressService.addAddress(address);
    }

    @RequestMapping(value = "/getAllAddress/{userId}")
    public List<Address> getAddressByUserId(@PathVariable long userId) {
      return  crudAddressService.getAllAddress(userId);
    }

    @RequestMapping(value = "/getAddress/{id}")
    public Address getAddress(@PathVariable long id) {
        return  crudAddressService.getAddress(id);
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT)
    public void getAddress(@RequestBody Address address) {
        crudAddressService.updateAddress(address);
    }

    @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable long id) {
        crudAddressService.deleteAddress(id);
    }

}

