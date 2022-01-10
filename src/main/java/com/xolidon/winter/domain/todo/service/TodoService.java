package com.xolidon.winter.domain.todo.service;

import com.xolidon.winter.domain.common.dto.PageRequest;
import com.xolidon.winter.domain.todo.dto.TodoDto;
import com.xolidon.winter.domain.todo.dto.TodoSearch;
import com.xolidon.winter.domain.todo.dto.TodoUpdate;
import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.domain.todo.predicate.TodoPredicate;
import com.xolidon.winter.domain.todo.projection.TodoProjection;
import com.xolidon.winter.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public Page<TodoDto> getTodoList(TodoSearch search, PageRequest pageRequest) {
        return todoRepository.findAll(TodoPredicate.list(search), pageRequest.of(), TodoProjection.DEFAULT);
    }

    public Optional<Todo> getTodo(Long todoId) {
        return todoRepository.findById(todoId);
    }

    public void save(TodoUpdate todoUpdate) {
        todoRepository.save(todoUpdate.toEntity());
    }

    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }
}
