package dev.ironsync.dto.workoutSession;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public record WorkoutSessionCreateDto(
        @NotNull(message = "Time spent cannot be null")
        @Positive(message = "Time spent must be greater than zero")
        @Max(value = 86400, message = "Time spent cannot exceed 24 hours (86400 seconds)")
        Long timeSpentSeconds,

        @NotNull(message = "Start time cannot be null")
        LocalDateTime startTime,

        @NotNull(message = "End time cannot be null")
        LocalDateTime endTime,

        List<Long> exerciseIds
) {}
