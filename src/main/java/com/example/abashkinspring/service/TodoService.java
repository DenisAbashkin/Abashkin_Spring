package com.example.abashkinspring.service;

import com.example.abashkinspring.entity.TodoEntity;
import com.example.abashkinspring.entity.UserEntity;
import com.example.abashkinspring.repository.TodoRepo;
import com.example.abashkinspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public TodoEntity complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return todoRepo.save(todo);
    }
}
