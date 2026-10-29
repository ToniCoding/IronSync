package dev.ironsync.controller;

import dev.ironsync.dto.user.UserRegisterRequestDTO;
import dev.ironsync.dto.user.UserRegisterResponseDTO;
import dev.ironsync.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@RestControllerAdvice
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDTO> register(
            @Valid @RequestBody UserRegisterRequestDTO userRegisterRequestDTO
    ) {
        UserRegisterResponseDTO response = userService.register(userRegisterRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
