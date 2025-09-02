package com.example.mes_service.Service;

import com.example.mes_service.dto.login.LoginRequest;
import com.example.mes_service.dto.login.LoginResponse;
import com.example.mes_service.Entity.Employee;
import com.example.mes_service.Repository.EmployeeRepository;
import com.example.mes_service.Service.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    /**
     * 사용자 인증 및 JWT 토큰 발급
     */
    public LoginResponse authenticate(LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByEmployeeId(loginRequest.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사원번호입니다."));

        if (!passwordEncoder.matches(loginRequest.getPassword(), employee.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 비밀번호가 일치하면 JWT 토큰 생성 및 반환
        String token = jwtProvider.createToken(employee.getEmployeeId(), employee.getRole());
        return new LoginResponse(token, employee.getRole(), employee.getEmployeeId());
    }
}