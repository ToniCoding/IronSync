package dev.ironsync.service;

import dev.ironsync.dto.user.UserRegisterRequestDTO;
import dev.ironsync.dto.user.UserRegisterResponseDTO;
import dev.ironsync.entity.User;
import dev.ironsync.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserRegisterResponseDTO register(
            UserRegisterRequestDTO userRegisterRequestDTO
    ) {
        if (userRepository.existsByEmailIgnoreCase(userRegisterRequestDTO.email())) {
            throw new RuntimeException("Email already in use.");
        }

        if (userRepository.existsByUsernameIgnoreCase(userRegisterRequestDTO.username())) {
            throw new RuntimeException("Username already in use.");
        }

        User user = mapToUserEntity(userRegisterRequestDTO);

        User savedUser = userRepository.save(user);
        return mapToUserRegisterResponseDTO(savedUser);
    }

    private User mapToUserEntity(UserRegisterRequestDTO userRegisterRequestDTO) {
        return new User(
            userRegisterRequestDTO.username(),
            userRegisterRequestDTO.email(),
            passwordEncoder.encode(userRegisterRequestDTO.password()),
            userRegisterRequestDTO.birthDate(),
            userRegisterRequestDTO.gender(),
            userRegisterRequestDTO.role()
        );
    }

    private UserRegisterResponseDTO mapToUserRegisterResponseDTO(User user) {
        return UserRegisterResponseDTO.fromEntity(user);
    }
}
