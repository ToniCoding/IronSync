package dev.ironsync.repository;

import dev.ironsync.entity.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {

    List<WorkoutSession> findByUserId(Long userId);

    List<WorkoutSession> findByUserIdAndSessionDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
