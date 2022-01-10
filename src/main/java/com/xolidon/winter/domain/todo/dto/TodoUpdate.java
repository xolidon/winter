package com.xolidon.winter.domain.todo.dto;

import com.xolidon.winter.domain.todo.entity.Todo;
import com.xolidon.winter.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TodoUpdate {
    @NotBlank(message = "할일 내용을 입력해주세요.")
    private String content;

    @NotNull
    private Long userId;

    private LocalDateTime dueDate;

    public Todo toEntity() {
        return Todo.builder()
                .content(this.content)
                .user(User.builder().userId(this.userId).build())
                .dueDate(this.dueDate)
                .build();
    }
}
