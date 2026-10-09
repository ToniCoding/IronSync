package dev.ironsync.repository;

import dev.ironsync.entity.Exercise;
import dev.ironsync.model.EquipmentType;
import dev.ironsync.model.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    boolean existsByNameIgnoreCase(String name);

    Optional<Exercise> findByNameIgnoreCase(String name);

    List<Exercise> findByTargetMuscles(MuscleGroup targetMuscles);

    List<Exercise> findByEquipmentNeeded(EquipmentType equipmentNeeded);

    List<Exercise> findByTargetMusclesAndEquipmentNeeded(MuscleGroup targetMuscles, EquipmentType equipmentNeeded);
}
