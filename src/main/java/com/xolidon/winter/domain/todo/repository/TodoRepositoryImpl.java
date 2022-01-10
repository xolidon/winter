package com.xolidon.winter.domain.todo.repository;

import com.querydsl.jpa.JPQLQuery;
import com.xolidon.winter.domain.todo.dto.TodoDto;
import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.querydsl.QuerydslRepository;

public class TodoRepositoryImpl extends QuerydslRepository<Todo, TodoDto> implements TodoRepositoryCustom {

    public TodoRepositoryImpl() {
        super(Todo.class);
    }

    @Override
    public JPQLQuery<Todo> from() {
        return null;
    }
}
