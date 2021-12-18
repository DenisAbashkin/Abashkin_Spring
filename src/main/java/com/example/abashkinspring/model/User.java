package com.example.abashkinspring.model;

import com.example.abashkinspring.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {//в папке model указываются только те поля, которые будут использоваться на клиенте
    private Long id;
    private String username;
    private List<Todo> todos;


    public static User toModel(UserEntity entity){//Принимаем Entity и делаем из нее модель и отправляем уже без пароля
        User model = new User();
        model.setId((entity.getId()));
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));//Преобразует массив entity в массив моделей
        //список был преобразован в стрим, а потом для каждого элемента массива исполнили функцию .map toModel/ collect обратно преобразовывает в лист
        return model;
    }




    public User() {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
