package com.xolidon.winter.domain.user.dto;

import com.xolidon.winter.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserUpdate {
    @NotBlank(message = "사용자명을 입력해주세요.")
    private String userName;

    @Email(message = "잘못된 이메일 형식입니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public User toEntity() {
        return User.builder()
                .userName(this.userName)
                .email(this.email)
                .password(password)
                .build();
    }

}
