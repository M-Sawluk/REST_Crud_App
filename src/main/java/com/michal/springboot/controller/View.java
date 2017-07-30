package com.michal.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mike on 2017-07-30.
 */
@Controller
public class View {

    @RequestMapping("/home")
    public String getView(){
        return "home";
    }


}
