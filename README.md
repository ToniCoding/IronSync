# IronSync – The Strength Operating System

IronSync is a powerful fitness application designed to manage and track workouts efficiently. With a focus on strength training, this application allows users to load exercises, track their progress, and organize workout entries. It is built with flexibility and scalability in mind, ensuring seamless user experience for all fitness enthusiasts.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Getting Started](#getting-started)
4. [Dependencies](#dependencies)
5. [Usage](#usage)
6. [Project Structure](#project-structure)
7. [Release Notes](#release-notes)
8. [Contributing](#contributing)
9. [License](#license)

---

## Project Overview

IronSync is a system built for strength training enthusiasts who want to track and optimize their workouts. The application allows users to:

- Load exercises from predefined data sources.
- Extract relevant data about exercises (name, description, muscle group).
- Create custom workout entries composed of exercises, repetitions, and series.
- Track and analyze progress over time.

---

## Features

- **Exercise Management**: Load a list of default exercises from a data source, extract detailed exercise data, and build custom `Exercise` objects.
- **Workout Entry System**: Track workout entries consisting of specific exercises, repetitions, and series. Each entry is connected to a particular exercise with corresponding metrics.
- **Data Extraction**: Efficiently extract exercise details (name, description, muscle group) to use within different parts of the application.
- **Custom Workouts**: Build workout entries dynamically based on user input, including the name of the exercise, number of repetitions, and series.

---

## Getting Started

To get started with IronSync, follow these steps:

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ironSync.git
cd ironSync
```

2. Set up Dependencies

IronSync requires Java 11 or later to run. You also need Gradle for build automation.

    Install Java: Make sure you have Java 11 or later installed.

    Install Gradle: Follow the installation instructions for Gradle on Gradle's official site.

3. Build and Run

Once you have the repository cloned and dependencies set up, you can build and run the project with Gradle:

gradle clean build
gradle run

Dependencies

IronSync uses the following libraries:

    Jackson for JSON parsing: com.fasterxml.jackson.core and com.fasterxml.jackson.databind

    Gradle for build automation.

Make sure you have Gradle configured correctly to resolve these dependencies.
Usage

IronSync offers a simple and intuitive way to manage workout data. Here is a basic example of how to use it:
Loading Default Exercises

ExerciseController exerciseController = new ExerciseController();
List<Exercise> exercises = exerciseController.loadExercises();

Extracting Exercise Data

List<String> exerciseData = exerciseController.extractExerciseData("Push-Up");
System.out.println(exerciseData);  // Output: [Push-Up, Push-up exercise description, Chest]

Building a Workout Entry

WorkoutEntryController workoutEntryController = new WorkoutEntryController();
WorkoutEntry entry = workoutEntryController.createWorkoutEntry("Push-Up", 15, 3);

Project Structure

```text
src/
├── main/
│ ├── java/
│ │ ├── com/
│ │ │ ├── ironsync/
│ │ │ │ ├── controller/
│ │ │ │ │ ├── ExerciseController.java
│ │ │ │ │ ├── WorkoutEntryController.java
│ │ │ │ │ └── ...
│ │ │ │ ├── data/
│ │ │ │ │ ├── ExercisesLoader.java
│ │ │ │ ├── model/
│ │ │ │ │ ├── Exercise.java
│ │ │ │ │ ├── WorkoutEntry.java
│ │ │ │ └── config/
│ │ │ │ └── AppConstants.java
└── build.gradle
```

Release Notes
v1.0.0 (2025-05-01)

    Initial release of IronSync with core features:

        Exercise loading from a JSON data source.

        Extraction of exercise data (name, description, muscle group).

        Creation of workout entries containing exercises, repetitions, and series.

        Basic error handling added for missing exercise data.

        Object-Oriented design allowing for easy extension of features.

        ExerciseController is now ready to integrate with WorkoutEntryController.

Contributing

We welcome contributions! If you want to improve IronSync, follow these steps:

    Fork the repository.

    Create a new branch (git checkout -b feature-branch).

    Commit your changes (git commit -am 'Add new feature').

    Push to your branch (git push origin feature-branch).

    Create a new Pull Request.

License

IronSync is open-source software released under the MIT License. See the LICENSE file for details.