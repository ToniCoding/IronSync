package dev.ironsync.dto.workoutSession;

import dev.ironsync.dto.exercise.ExerciseSummaryDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record WorkoutInformationDto(
        Long id,
        Long userId,
        Long timeSpentSeconds,
        LocalDate sessionDate,
        LocalDateTime startTime,
        LocalDateTime endTime,
        BigDecimal rating,
        List<ExerciseSummaryDto> exercises
) {}
