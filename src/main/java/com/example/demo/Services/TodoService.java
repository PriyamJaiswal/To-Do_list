package com.example.demo.Services;

import com.example.demo.Models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> todoList = new ArrayList<>();
    private Long counter = 1L;

    public Todo addTodo(String title) {
        Todo todo = new Todo(counter++, title, false);
        todoList.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public Todo getTodoById(Long id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteTodo(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }
}
