# Release notes

---

## IronSync 1.0.0

#### *IronSync foundations*
###### Version goal: IronSync have now the most basic functionalities
###### Release date: *25-05-2025*

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

---

## IronSync 1.1.0

#### *Data persistence & Exercise Overhaul*
###### Version goal: IronSync having data persistence
###### Release date: *17-07-2025*

### Added
- Created a new directory named `user_data` to store workout sessions and user-related data.
- Added `WorkoutDTO`, a dedicated Data Transfer Object for encapsulating workout data to be serialized into JSON.
- Implemented `JsonSerializer`, a utility class responsible for converting DTOs into properly structured JSON.
- Added a method to serialize and persist workout data into a JSON file inside the `user_data` directory.
- Added helpers package.
- Added `ExerciseManager` file in charge of converting friendly exercise names from user to internal identifiers.
- Added two more options to get the time and date in `ParseDate`.
- Added "Pending" and "Known issues" sections to README.

### Fixed
- Corrected `createStorageFile` logic to properly check whether the `user_data` directory is being created successfully.
- Fixed `Workout` constructor length checks, which were previously validating incorrect character limits.
- Resolved a bug where attempting to register an additional exercise could throw an exception.
- Fixed a bug in createNewWorkoutEntry that caused the input for a new exercise not to be sanitized if the user previously entered an exercise that already existed.
- Fixed a bug that was setting the time field to null instead of the corresponding time.

### Changed
- Updated the constant `USER_WORKOUT_DATA_PATH` in `AppConstants` to reflect the new `user_data` directory.
- Replaced `FileWriter` with `BufferedWriter` in `writeToFile` for improved I/O efficiency.
- Updated `build.gradle` to mark the `java` directory as the source root instead of `src`.
- The number of sets is now automatically derived from the repetitions input; users no longer input sets manually.
- Refactored `UserController.createNewWorkout` to handle workout entry creation internally, improving clarity in `Main`.
- Moved exercise registration logic into `UserController` for better cohesion.
- Updated `README.md` and `.gitignore` accordingly.
- Minor changes to `FileManager`.
- Refactor of the method used to get the date, time and datetime to be more clear. New name: `getCurrentDateAndTimeFormatted`.
- Refactor of `createNewWorkoutEntry` to avoid variable re-assignation and consistent data about the exercise.
- `WorkoutDTO` now returns the workout ending date.
- `Workout` cascade now accepts time as an argument.

### Removed
- Removed the deprecated method `registered_data` in `FileManager`.
- Removed `ObjectUtils` class.
- Removed duplicated method to normalize user input in `UserController`.

### Known issues
- Normalize friendly exercises name does not work with multiple word exercises.

### Pending tasks
- Refactor code to inject dependencies (like builder/controller classes) via constructor or arguments instead of direct instantiation with `new`, to improve modularity and testability.

---

## IronSync 1.2.0

#### *IronSync DB integration*
###### Version goal: *IronSync working with databases*
###### Release date: *Unreleased*

### Added
- Added connection to MySQL databases.
- Added methods to test and execute queries to MySQL databases.
- Added the following attributes, getters and setters to User model:
  - Alias.
  - Email.
  - Age.
  - Weight.
  - Height.
- Added the following functionality for IronSync to interact with `users` table in database:
  - Add user.
  - Edit user.
  - Delete user.
- Added the following functionality for IronSync to interact with `streak` table in database:
  - Create a new streak.
  - Add days to a streak.
  - Reset a streak.
- Added `execUpdate` method to interact with any action that requires an update at database level.
- Implemented an interface to `UserInterface`.

### Fixed
- Fixed a bug where user_workout would be serialized with a starting newline and comma.
- Fixed a bug where when creating a new user, the experience would be set to `null`.

### Changed
- Refactor of User model attribute `uniqueId` to `id` to simplify.
- Changed `createStatement` to `prepareStatement` to avoid SQL injection.

### Infrastructure
- Revised application versioning system.
- Updated version number from 1.1.1 to 1.2.0 to align with the new versioning system.

