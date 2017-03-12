package com.michal.springboot.controller;

import com.michal.springboot.domain.User;
import com.michal.springboot.service.CrudUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mike on 2017-03-12.
 */
@RestController
public class PageUserController {

    private CrudUserService crudUserService;

    public PageUserController(CrudUserService crudUserService) {
        this.crudUserService = crudUserService;
    }

    @RequestMapping("/page/{pageNr}/ammount/{userAmmount}")
    public List<User> getPages(@PathVariable Integer pageNr , @PathVariable Integer userAmmount){
        return crudUserService.getPages(pageNr,userAmmount);
    }
}
