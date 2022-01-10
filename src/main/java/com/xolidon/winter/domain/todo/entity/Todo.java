package com.xolidon.winter.domain.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xolidon.winter.domain.user.entity.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_todo")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Todo implements Serializable {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "todo_id", nullable = false)
    private Long todoId;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isDone;

    private LocalDateTime dueDate;

    @CreatedDate
    @Column(name = "reg_date", nullable = false)
    private LocalDateTime createdAt;
}
