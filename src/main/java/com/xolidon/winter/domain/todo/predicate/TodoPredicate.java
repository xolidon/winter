package com.xolidon.winter.domain.todo.predicate;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.xolidon.winter.domain.todo.dto.TodoSearch;

import static com.xolidon.winter.domain.todo.entity.QTodo.todo;


public class TodoPredicate {
    public static Predicate list(TodoSearch search) {
        return ExpressionUtils.allOf(
                todo.content.eq(search.getContent()),
                todo.todoId.eq(search.getUserId())
        );
    }
}
