package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService() {
        // TodoEntity entity = TodoEntity.builder().title("My First Todo Item").build();
        TodoEntity entity = TodoEntity.builder().userId("user01").title("My First Todo Item").build();

        // TodoEntity 저장
        repository.save(entity);

        // TodoEntity 검색
        // TodoEntity savedEntity = repository.findByUserId(entity.getUserId()).get(0);
        TodoEntity savedEntity = repository.searchByUserId(entity.getUserId()).get(0);

        return savedEntity.getTitle();
    }
}
