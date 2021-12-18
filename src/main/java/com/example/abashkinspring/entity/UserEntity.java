package com.example.abashkinspring.entity;

import javax.persistence.*;
import java.util.List;

@Entity//Для того чтобы JPA сделать таблицу из этой сущности (entity переводится как сущность)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")//Один пользователь имеет много задач.// Каскадом мы сообщаем, что при удалении пользователя нужно удалить и его задачи
    private List<TodoEntity> todos;

    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
