CREATE DATABASE iron_sync;
-- USE iron_sync;

CREATE OR REPLACE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    alias VARCHAR(50) NOT NULL,
    password VARCHAR(64) NOT NULL,
    role ENUM('user','admin') NOT NULL,
    status ENUM('active','inactive','banned') NOT NULL,
    age INT,
    weight INT,
    height INT UNSIGNED,
    experience INT UNSIGNED,
    streak INT NOT NULL,
    days_trained INT UNSIGNED DEFAULT 0
);

CREATE OR REPLACE TABLE trainings(
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    workout_name VARCHAR(30) NOT NULL,
    workout_notes VARCHAR(250) NOT NULL,
    workout_date DATE NOT NULL,
    workout_time TIME NOT NULL,
    workout_exercises JSON NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE RESTRICT
);

CREATE OR REPLACE TABLE custom_exercises(
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    muscle_group VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    difficulty ENUM('beginner','intermediate','advanced') NOT NULL DEFAULT 'beginner',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE RESTRICT
);

CREATE OR REPLACE TABLE streak(
	user_id INT PRIMARY KEY NOT NULL,
    streak_days INT NOT NULL DEFAULT 0,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE OR REPLACE TABLE exercises(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    muscle_group VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    difficulty ENUM('beginner','intermediate','advanced') NOT NULL DEFAULT 'beginner',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
