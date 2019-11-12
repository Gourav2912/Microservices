package com.example.sample.coreservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceJPA {

    UserRepository userRepository;

    @Autowired
    public UserServiceJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Map<String,UserRest> users;
    public String createUser(  UserDetailsRequestModel userDetails){

        String userId = UUID.randomUUID().toString();

        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setEmailId(userDetails.getEmailId());
        userEntity.setFirstName(userDetails.getFirstName());
        userEntity.setLastName(userDetails.getLastName());
        userEntity.setPassword(userDetails.getPassword());

        userRepository.save(userEntity);

     /*   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserRest userRest=modelMapper.map(userDetails, UserRest.class);
        userRest.setUserId(userId);*/

        return userId;
    }

    public UserRest getUserById( Long key){


        if(userRepository.findById(key)!=null)
        {

            //System.out.println("he;llllllllllllll");
            Optional<UserEntity> ue= userRepository.findById(key);
            UserRest ur= new UserRest();
            ur.setUserId(ue.get().getUserId());
            ur.setEmailId(ue.get().getEmailId());
            ur.setFirstName(ue.get().getFirstName());
            ur.setLastName(ue.get().getLastName());



            return ur;
        }

        else

            return null;
    }

    public UserRest getUserByEmail( String emailId){


        if(userRepository.findByEmailId(emailId)!=null)
        {
            UserEntity ue= userRepository.findByEmailId(emailId);
            UserRest ur= new UserRest();
            ur.setUserId(ue.getUserId());
            ur.setEmailId(ue.getEmailId());
            ur.setFirstName(ue.getFirstName());
            ur.setLastName(ue.getLastName());

            return ur;
        }

        else

            return null;
    }

    public UserRest getUserByUserId( String userId){


        if(userRepository.findByUserId(userId)!=null)
        {
            UserEntity ue= userRepository.findByUserId(userId);
            UserRest ur= new UserRest();
            ur.setUserId(ue.getUserId());
            ur.setEmailId(ue.getEmailId());
            ur.setFirstName(ue.getFirstName());
            ur.setLastName(ue.getLastName());

            return ur;
        }

        else

            return null;
    }
}
