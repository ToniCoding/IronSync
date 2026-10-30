package dev.ironsync.controller;

import dev.ironsync.dto.workoutSession.WorkoutSessionCreateDto;
import dev.ironsync.dto.workoutSession.WorkoutInformationDto;
import dev.ironsync.service.WorkoutSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workout-sessions")
@RequiredArgsConstructor
public class WorkoutSessionController {

    private final WorkoutSessionService workoutSessionService;

    @PostMapping
    public ResponseEntity<WorkoutInformationDto> createSession(
            @Valid @RequestBody WorkoutSessionCreateDto createDto
    ) {
        WorkoutInformationDto createdSession = workoutSessionService.createSession(createDto);
        return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutInformationDto> getSessionById(
            @PathVariable Long id
    ) {
        WorkoutInformationDto sessionDetails = workoutSessionService.getSessionDetailsById(id);
        return ResponseEntity.ok(sessionDetails);
    }
}
