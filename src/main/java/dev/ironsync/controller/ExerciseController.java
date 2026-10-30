package dev.ironsync.controller;

import dev.ironsync.dto.exercise.ExerciseCreateDto;
import dev.ironsync.dto.exercise.ExerciseResponseDto;
import dev.ironsync.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ExerciseResponseDto> createExercise(
            @Valid @RequestBody ExerciseCreateDto createDto
    ) {
        ExerciseResponseDto createdExercise = exerciseService.createExercise(createDto);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> getExerciseById(
            @PathVariable Long id
    ) {
        ExerciseResponseDto exerciseDetails = exerciseService.getExerciseById(id);
        return ResponseEntity.ok(exerciseDetails);
    }
}
