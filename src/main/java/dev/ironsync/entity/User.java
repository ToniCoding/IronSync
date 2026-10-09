package dev.ironsync.entity;

import dev.ironsync.model.Gender;
import dev.ironsync.model.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role = Role.USER;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(name = "register_date", nullable = false, updatable = false)
    private Instant registerDate = Instant.now();

    @Column(name = "last_login")
    private Instant lastLogin;

    // Custom constructor for manual creation without generated fields
    public User(String username, String email, String password, LocalDate birthDate, Gender gender, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.gender = gender;
        this.role = role != null ? role : Role.USER;
        this.registerDate = Instant.now();
    }

    // Dynamic Derived Attribute (computed on demand to stay up to date)
    public int getAge() {
        if (this.birthDate == null) {
            return 0;
        }
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @PrePersist
    protected void onCreate() {
        this.registerDate = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
