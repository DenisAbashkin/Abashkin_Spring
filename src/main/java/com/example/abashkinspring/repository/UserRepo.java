package com.example.abashkinspring.repository;

import com.example.abashkinspring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {//CrudRepository - с- create r - read u - update d -delete
    UserEntity findByUsername(String username);
}
