package com.example.abashkinspring.service;

import com.example.abashkinspring.entity.UserEntity;
import com.example.abashkinspring.exception.UserAlreadyExistException;
import com.example.abashkinspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired//Иницилизация репозитория
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) !=null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }
}
