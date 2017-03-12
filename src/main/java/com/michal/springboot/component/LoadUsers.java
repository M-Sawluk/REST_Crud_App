package com.michal.springboot.component;

import com.michal.springboot.domain.User;
import com.michal.springboot.repository.UserRepository;
import com.michal.springboot.service.UserGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Mike on 2017-03-12.
 */

@Component
public class LoadUsers {

    private UserRepository userRepository;

    private UserGenerator userGenerator;

    public LoadUsers(UserRepository userRepository, UserGenerator userGenerator) {
        this.userRepository = userRepository;
        this.userGenerator = userGenerator;
    }

    @PostConstruct
    public void loadAtStart() {

        for (int i = 0; i < 100; i++) {
            User randomUser = userGenerator.getRandomUser();
            userRepository.save(randomUser);
        }
    }

}
