package com.michal.springboot.service;

import com.michal.springboot.domain.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


/**
 * Created by Mike on 2017-03-12.
 */
@Service
public class UserGenerator {

    private List<String> firstNames;
    private List<String> lastNames;
    private final Random random = new Random();


    public UserGenerator() {

        try {
            firstNames = Files.readAllLines(Paths.get(new ClassPathResource("names").getURI()));
            lastNames = Files.readAllLines(Paths.get(new ClassPathResource("lastnames").getURI()));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read");
        }
    }

    public User getRandomUser(){

        User user = new User();
        user.setFirstName(getRandomName());
        user.setSecondName(getRandomLastName());
        return user;
    }

    public String getRandomName(){
        return firstNames.get(random.nextInt(firstNames.size())).trim();
    }

    public String getRandomLastName(){
        return lastNames.get(random.nextInt(lastNames.size())).trim();
    }

}
