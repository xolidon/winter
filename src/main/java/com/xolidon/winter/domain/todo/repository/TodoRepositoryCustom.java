package com.xolidon.winter.domain.todo.repository;

import com.xolidon.winter.domain.todo.dto.TodoDto;
import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.querydsl.QuerydslRepositoryCustom;

public interface TodoRepositoryCustom extends QuerydslRepositoryCustom<Todo, TodoDto> {
}
