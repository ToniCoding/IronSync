package dev.ironsync.dto.exercise;

import dev.ironsync.model.EquipmentType;
import dev.ironsync.model.MuscleGroup;

public record ExerciseResponseDto(
        Long id,
        String name,
        String description,
        MuscleGroup targetMuscles,
        EquipmentType equipmentNeeded
) {}
