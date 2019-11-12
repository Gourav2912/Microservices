package com.example.sample.coreservice;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    UserEntity findById(long id);
    UserEntity findByEmailId(String emailId);
    UserEntity findByUserId(String userId);
}
