package service;

import dev.ironsync.dto.exercise.ExerciseCreateDto;
import dev.ironsync.dto.exercise.ExerciseResponseDto;
import dev.ironsync.entity.Exercise;
import dev.ironsync.model.EquipmentType;
import dev.ironsync.model.MuscleGroup;
import dev.ironsync.repository.ExerciseRepository;
import dev.ironsync.service.ExerciseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @Test
    @DisplayName("Should successfully create and save an exercise")
    void shouldSuccessfullyCreateExercise() {
        // Arrange
        ExerciseCreateDto exerciseToSave = new ExerciseCreateDto("Deadlift", "Deadlift", MuscleGroup.LOWER_BACK, EquipmentType.BARBELL);

        Exercise savedExercise = new Exercise();
        savedExercise.setId(1L);
        savedExercise.setName("Deadlift");
        savedExercise.setTargetMuscles(MuscleGroup.LOWER_BACK);
        savedExercise.setEquipmentNeeded(EquipmentType.BARBELL);

        when(exerciseRepository.save(any(Exercise.class))).thenReturn(savedExercise);

        // Act
        ExerciseResponseDto result = exerciseService.createExercise(exerciseToSave);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.name()).isEqualTo("Deadlift");
        verify(exerciseRepository).save(any(Exercise.class));
    }
}