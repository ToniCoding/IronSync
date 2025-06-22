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
- Created a new directory named `user_data` to store workout sessions and user-related data.
- Added `WorkoutDTO`, a dedicated Data Transfer Object for encapsulating workout data to be serialized into JSON.
- Implemented `JsonSerializer`, a utility class responsible for converting DTOs into properly structured JSON.
- Added a method to serialize and persist workout data into a JSON file inside the `user_data` directory.
- Added "Pending" and "Known issues" sections to README.

### Fixed
- Corrected `createStorageFile` logic to properly check whether the `user_data` directory is being created successfully.
- Fixed `Workout` constructor length checks, which were previously validating incorrect character limits.
- Resolved a bug where attempting to register an additional exercise could throw an exception.

### Changed
- Updated the constant `USER_WORKOUT_DATA_PATH` in `AppConstants` to reflect the new `user_data` directory.
- Replaced `FileWriter` with `BufferedWriter` in `writeToFile` for improved I/O efficiency.
- Updated `build.gradle` to mark the `java` directory as the source root instead of `src`.
- The number of sets is now automatically derived from the repetitions input; users no longer input sets manually.
- Refactored `UserController.createNewWorkout` to handle workout entry creation internally, improving clarity in `Main`.
- Moved exercise registration logic into `UserController` for better cohesion.
- Updated `README.md` and `.gitignore` accordingly.
- Minor changes to `FileManager`.

### Removed
- Removed the deprecated method `registered_data` in `FileManager`.
- Removed `ObjectUtils` class.

### Known issues
- Time is set to null because the data transferred to `WorkoutDTO` is the current datetime, and it's not separated.

### Pending tasks
- Refactor code to inject dependencies (like builder/controller classes) via constructor or arguments instead of direct instantiation with `new`, to improve modularity and testability.
