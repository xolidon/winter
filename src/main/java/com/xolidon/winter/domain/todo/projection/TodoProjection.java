package com.xolidon.winter.domain.todo.projection;

import com.querydsl.core.types.QBean;
import com.xolidon.winter.domain.todo.dto.TodoDto;
import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.querydsl.Projection;

public class TodoProjection {
    public static final Projection<Todo, TodoDto> DEFAULT = new Projection<Todo, TodoDto>() {
        @Override
        public QBean<TodoDto> getProjection() {
            return null;
        }
    };
}
