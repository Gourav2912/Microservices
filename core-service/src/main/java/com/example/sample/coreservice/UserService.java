package com.example.sample.coreservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {


    Map<String,UserRest> users;
    public UserRest createUser(  UserDetailsRequestModel userDetails){

        String userId = UUID.randomUUID().toString();
        UserRest userrest = new UserRest();
        userrest.setFirstName(userDetails.getFirstName());
        userrest.setLastName(userDetails.getLastName());
        userrest.setEmailId(userDetails.getEmailId());
        userrest.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId,userrest);
        return userrest;
    }

    public UserRest getUser(  String key){


        if(users.containsKey(key) )
        {
            return users.get(key);
        }

        else

        return null;
    }


}
