package dev.ironsync.service;

import dev.ironsync.dto.exercise.ExerciseCreateDto;
import dev.ironsync.dto.exercise.ExerciseResponseDto;
import dev.ironsync.exception.ResourceNotFoundException;
import dev.ironsync.entity.Exercise;
import dev.ironsync.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Transactional
    public ExerciseResponseDto createExercise(ExerciseCreateDto dto) {
        if (exerciseRepository.existsByNameIgnoreCase(dto.name())) {
            throw new IllegalArgumentException("An exercise with the name '" + dto.name() + "' already exists.");
        }

        Exercise exercise = new Exercise();
        exercise.setName(dto.name());
        exercise.setDescription(dto.description());
        exercise.setTargetMuscles(dto.targetMuscles());
        exercise.setEquipmentNeeded(dto.equipmentNeeded());

        Exercise savedExercise = exerciseRepository.save(exercise);

        return mapToDto(savedExercise);
    }

    @Transactional(readOnly = true)
    public ExerciseResponseDto getExerciseById(Long id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with ID: " + id));

        return mapToDto(exercise);
    }

    private ExerciseResponseDto mapToDto(Exercise exercise) {
        return new ExerciseResponseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getDescription(),
                exercise.getTargetMuscles(),
                exercise.getEquipmentNeeded()
        );
    }
}
