package com.example.abashkinspring.controller;

import com.example.abashkinspring.entity.UserEntity;
import com.example.abashkinspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//RestController - потому что мы делаем rest сервис (Это аннотация, которая говорит spring, что это контроллер)
@RequestMapping("/users") //Запросы которые будет обрабатывать этот контроллер должны начинаться с /users
public class UserController {

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try {
            if (userRepo.findByUsername(user.getUsername()) !=null){
                return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
            }
            userRepo.save(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping//Указываем что это get запрос
    public ResponseEntity getUsers(){
            try {
                return ResponseEntity.ok("Сервер работает!");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
    }
}
