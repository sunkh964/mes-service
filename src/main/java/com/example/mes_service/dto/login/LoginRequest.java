package com.example.mes_service.dto.login;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "아이디는 필수 사항입니다.")
    private String employeeId;

    @NotBlank(message = "비밀번호는 필수 사항입니다.")
    private String password;
}