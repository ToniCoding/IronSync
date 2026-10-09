package dev.ironsync.dto.user;

import dev.ironsync.entity.User;

import java.time.Instant;

public record UserRegisterResponseDTO (
        Long id,
        String username,
        String email,
        Instant registerDate
) {
    public static UserRegisterResponseDTO fromEntity(User user) {
        return new UserRegisterResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRegisterDate()
        );
    }
}
