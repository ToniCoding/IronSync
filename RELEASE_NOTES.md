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
