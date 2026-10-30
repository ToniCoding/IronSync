package dev.ironsync.dto.exercise;

import dev.ironsync.model.EquipmentType;
import dev.ironsync.model.MuscleGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExerciseCreateDto(
        @NotBlank(message = "Exercise name cannot be blank")
        @Size(max = 200, message = "Exercise name cannot exceed 200 characters")
        String name,

        String description,

        @NotNull(message = "Target muscle group cannot be null")
        MuscleGroup targetMuscles,

        @NotNull(message = "Equipment needed cannot be null")
        EquipmentType equipmentNeeded
) {}
