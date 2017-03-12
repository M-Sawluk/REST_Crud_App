package com.michal.springboot.repository;

import com.michal.springboot.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mike on 2017-03-09.
 */

public class UserInMemoryRepositoryImpl {

    private List<User> listOfUsers = new ArrayList<User>(Arrays.asList(
            new User(1L,"Michal","Es"),
            new User(2L,"Marlej", "Pe"),
            new User(3L,"Ka","Te")));

    public List<User> getAllUsers(){
        return listOfUsers;
    }

    public User getUser(long id){
        return listOfUsers.stream().filter(u -> u.getId()==id)
                .findAny().get();
    }

    public void addUser(User user){
        listOfUsers.add(user);

    }
    public void deleteUser(long id){
        listOfUsers.removeIf(u ->u.getId()==id);
    }

    public void updateUser(long id , User user){

        for(int i=0;i<listOfUsers.size();i++){
            if(listOfUsers.get(i).getId()==id){
                listOfUsers.set(i,user);
                return;
            }
        }

    }

}
