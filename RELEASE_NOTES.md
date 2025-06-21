# Release notes

## [1.0.0] - 23-05-2025

### Added
- Basic functionality for the software.
- Creation cascade for workouts.
  - Workout builder - WorkoutEntry builder - Exercise builder
- The program now loads all default exercises without problems.
- Added README.md.
- Added RELEASE_NOTES.md.
- Gradle build system integration.
- Added utilities related to date, time, user inputs and numbers.
- Added custom exceptions package at `exceptions`.
- Added new methods to show a numbered list with options and process the user input between options.

### Fixed
- Fixed validation logic for repetitions and sets.

### Changed
- Refactor of `createNewWorkoutEntry` to avoid creating duplicate Exercise instances.

## [1.1.0] - Unreleased

### Added
- Added new directory called `user_data` to store workouts and data from the user.

### Fixed
- Fixed `createStorageFile` as it was not checking correctly if the `user_data` directory was being correctly created.
- Fixed `Workout` constructor length checks as it was checking that the character were shorter than the length rules.

### Changed
- The constant `USER_WORKOUT_DATA_PATH` at *AppConstants* now points to the newly created directory `user_data`.
- The method `writeToFile` no longer uses *FileWriter*, now uses *BufferedWriter* to be more efficient.
- Updated build.gradle to mark as sources root directory `java` and not `src`.
- User is no longer required to prompt the number of sets as it's automatically calculated with repetitions.
- Refactor `UserController.createNewWorkout` to not receive arguments and build the workout entry list inside it. Makes Main clearer.
- The register of the exercise is now done in `UserController`.
- Updated README.
- Updated .gitignore.