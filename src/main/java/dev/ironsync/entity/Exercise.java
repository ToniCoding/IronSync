package dev.ironsync.entity;

import dev.ironsync.model.EquipmentType;
import dev.ironsync.model.MuscleGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "exercises")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private MuscleGroup targetMuscles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EquipmentType equipmentNeeded;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;
        return id != null && Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
