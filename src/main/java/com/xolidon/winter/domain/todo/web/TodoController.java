package com.xolidon.winter.domain.todo.web;

import com.xolidon.winter.domain.common.dto.PageRequest;
import com.xolidon.winter.domain.todo.dto.TodoDto;
import com.xolidon.winter.domain.todo.dto.TodoSearch;
import com.xolidon.winter.domain.todo.dto.TodoUpdate;
import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("todo")
@RestController
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<Page<TodoDto>> list(TodoSearch search, PageRequest pageRequest) {
        return new ResponseEntity<>(todoService.getTodoList(search, pageRequest), HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> detail(@PathVariable("todoId") Long todoId) {
        Todo todo = todoService.getTodo(todoId).orElse(null);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity save(@RequestBody @Valid TodoUpdate todoUpdate) {
        todoService.save(todoUpdate);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity delete(@RequestBody Todo todo) {
        todoService.delete(todo);

        return new ResponseEntity(HttpStatus.OK);
    }
}
