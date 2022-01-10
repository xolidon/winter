package com.xolidon.winter.domain.todo.repository;

import com.xolidon.winter.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TodoRepository extends TodoRepositoryCustom, JpaRepository<Todo, Long>, QuerydslPredicateExecutor<Todo> {
}
