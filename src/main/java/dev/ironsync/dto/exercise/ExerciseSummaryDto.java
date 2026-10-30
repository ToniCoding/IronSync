package dev.ironsync.dto.exercise;

import java.math.BigDecimal;

public record ExerciseSummaryDto(
        Long id,
        String name,
        String targetMuscle,
        String equipmentNeeded
) {}
