package dev.ironsync.service;

import dev.ironsync.dto.exercise.ExerciseSummaryDto;
import dev.ironsync.dto.workoutSession.WorkoutInformationDto;
import dev.ironsync.dto.workoutSession.WorkoutSessionCreateDto;
import dev.ironsync.entity.Exercise;
import dev.ironsync.exception.ResourceNotFoundException;
import dev.ironsync.entity.User;
import dev.ironsync.entity.WorkoutSession;
import dev.ironsync.repository.ExerciseRepository;
import dev.ironsync.repository.UserRepository;
import dev.ironsync.repository.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {

    private final WorkoutSessionRepository workoutSessionRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    @Transactional
    public WorkoutInformationDto createSession(WorkoutSessionCreateDto dto) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Authenticated user not found: " + currentUserEmail));

        if (dto.endTime().isBefore(dto.startTime())) {
            throw new IllegalArgumentException("Session end time cannot be before start time");
        }

        List<Exercise> exercises = new ArrayList<>();
        if (dto.exerciseIds() != null && !dto.exerciseIds().isEmpty()) {
            exercises = exerciseRepository.findAllById(dto.exerciseIds());
            if (exercises.size() != dto.exerciseIds().size()) {
                throw new ResourceNotFoundException("One or more specified exercises could not be found");
            }
        }

        WorkoutSession workoutSession = WorkoutSession.builder()
                .user(user)
                .timeSpentSeconds(dto.timeSpentSeconds())
                .startTime(dto.startTime())
                .endTime(dto.endTime())
                .sessionDate(dto.startTime().toLocalDate())
                .rating(BigDecimal.valueOf(5.0))
                .exercises(exercises)
                .build();

        WorkoutSession savedSession = workoutSessionRepository.save(workoutSession);
        return mapToDto(savedSession);
    }

    @Transactional(readOnly = true)
    public WorkoutInformationDto getSessionDetailsById(Long id) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout session not found with ID: " + id));

        return mapToDto(workoutSession);
    }

    private WorkoutInformationDto mapToDto(WorkoutSession session) {
        List<ExerciseSummaryDto> exerciseDtos = session.getExercises().stream()
                .map(ex -> new ExerciseSummaryDto(
                        ex.getId(),
                        ex.getName(),
                        ex.getTargetMuscles() != null ? ex.getTargetMuscles().name() : null,
                        ex.getEquipmentNeeded() != null ? ex.getEquipmentNeeded().name() : null
                ))
                .toList();

        return new WorkoutInformationDto(
                session.getId(),
                session.getUser().getId(),
                session.getTimeSpentSeconds(),
                session.getSessionDate(),
                session.getStartTime(),
                session.getEndTime(),
                session.getRating(),
                exerciseDtos
        );
    }
}
