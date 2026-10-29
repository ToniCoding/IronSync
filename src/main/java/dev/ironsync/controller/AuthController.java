package dev.ironsync.controller;

import dev.ironsync.dto.user.LoginRequestDto;
import dev.ironsync.entity.User;
import dev.ironsync.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> authenticate(
            @Valid @RequestBody LoginRequestDto loginRequestDto
    ) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.email(),
                        loginRequestDto.password()
                )
        );

        User user = (User) authentication.getPrincipal();


        Map<String, Object> extraClaims = Map.of(
                "userId", user.getId(),
                "role", user.getRole()
        );

        String jwtToken = jwtService.generateToken(extraClaims, user);

        return ResponseEntity.ok(Map.of(
                "token", jwtToken,
                "tokenType", "Bearer",
                "email", user.getUsername(),
                "role", user.getRole().name()
        ));
    }
}
