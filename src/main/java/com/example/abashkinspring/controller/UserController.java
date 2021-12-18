package com.example.abashkinspring.controller;

import com.example.abashkinspring.entity.UserEntity;
import com.example.abashkinspring.exception.UserAlreadyExistException;
import com.example.abashkinspring.exception.UserNotFoundException;
import com.example.abashkinspring.repository.UserRepo;
import com.example.abashkinspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//RestController - потому что мы делаем rest сервис (Это аннотация, которая говорит spring, что это контроллер)
@RequestMapping("/users") //Запросы которые будет обрабатывать этот контроллер должны начинаться с /users
public class UserController {

    @Autowired//Иницилизация репозитория
    private UserService userService;


    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }catch (UserAlreadyExistException e){//Отлавливаем созданную ошибку в UserService
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping//Указываем что это get запрос
    public ResponseEntity getOneUser(@RequestParam Long id){
            try {
                return ResponseEntity.ok(userService.getOne(id));
            }catch (UserNotFoundException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Произошла ошибка");
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
