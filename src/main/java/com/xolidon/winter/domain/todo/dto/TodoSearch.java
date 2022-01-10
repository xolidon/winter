package com.xolidon.winter.domain.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoSearch {
    private String content;
    private Long userId;
}
