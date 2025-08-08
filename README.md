# IronSync - The Strength Operating System

IronSync is a powerful fitness application designed to manage and track workouts throughout a lifter's journey. The app allows users to register and monitor their progress with ease. It offers a wide variety of exercises that can be quickly added to any training session. And if the user wants to create a custom or non-existing exercise, they can do so effortlessly!

---

## Table of contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Dependencies](#dependencies)
4. [Project Structure](#project-structure)
5. [License](#license)

## Project Overview

IronSync is a system designed for training enthusiasts who want to track and optimize their progress effortlessly.

The application loads predefined exercises from a data source, extracts relevant data from user workouts, and analyzes this data over time to provide meaningful insights.

## Features

- **Exercise Management**: Users have access to a wide variety of preloaded exercises to include in their workouts.

- **Custom Exercise Creation**: Users can create their own custom exercises, which will be available alongside the default ones during workout sessions.

- **Workout Entry System**: A streamlined system allows users to easily log and manage their workouts and exercises.

- **Data Analysis**: IronSync analyzes completed workouts to generate metrics and performance insights over time.

- **Personalized Tips**: Based on workout data and post-session feedback, IronSync provides personalized tips tailored to the user’s performance and recovery status.

## Dependencies

The following dependencies and tools are required for IronSync to run properly:

- Jackson for JSON parsing:
  - com.fasterxml.jackson.core
  - com.fasterxml.jackson.databind
- Gradle for build automation.

Make sure you configure Gradle correctly to resolve these dependencies.

## Project structure

This is how IronSync is built from the core.

```text
src/
├── main/
│ ├── java/
│ │ ├── com/
│ │ │ ├── ironSync/
│ │ │ │ └── config/
│ │ │ │ │ ├── AppConstants.java
│ │ │ │ ├── controller/
│ │ │ │ │ ├── ExerciseController.java
│ │ │ │ │ ├── WorkoutEntryController.java
│ │ │ │ │ └── WorkoutController.java
│ │ │ │ ├── exceptions/
│ │ │ │ │ ├── Exceptions.java
│ │ │ │ ├── model/
│ │ │ │ │ ├── Exercise.java
│ │ │ │ │ ├── User.java
│ │ │ │ │ ├── Workout.java
│ │ │ │ │ ├── WorkoutEntry.java
│ │ │ │ ├── data/
│ │ │ │ │ ├── ExercisesLoader.java
│ │ │ │ ├── util/
│ │ │ │ │ ├── NumberUtils.java
│ │ │ │ │ ├── ObjectUtils.java
│ │ │ │ │ ├── ParseDate.java
│ │ │ │ │ ├── UserInputs.java
│ │ │ │ ├── view/
│ │ │ │ │ ├── WorkoutView.java
│ │ ├── com/
│ │ │ │ └── data/
│ │ │ │ │ ├── custom_exercises.json
│ │ │ │ │ ├── default_exercises.json
│ │ │ │ │ ├── user_workout.json
└── build.gradle
└── README.md
└── RELEASE_NOTES.md
```

## Release notes
To view the release notes, please refer to the *RELEASE_NOTES* file.

## License
Licensed under the GPL-3.0. Make sure to review the license before use.

## Planned improvements
### Long term
- Study the possibility of implementing Java string templates (Java 21).

### Short term
- Create comprehensive canvas about the software module communication.
- README overhaul.
