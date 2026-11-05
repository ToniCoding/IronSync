package dev.ironsync.dto.user;

import dev.ironsync.entity.User;

public record UserRegisterResponseDTO (
        Long id,
        String username,
        String email,
        java.time.LocalDateTime registerDate
) {
    public static UserRegisterResponseDTO fromEntity(User user) {
        return new UserRegisterResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
