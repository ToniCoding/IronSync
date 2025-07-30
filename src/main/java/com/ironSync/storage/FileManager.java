package com.ironSync.storage;

import com.ironSync.config.AppConstants;
import com.ironSync.dto.WorkoutDTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A utility class for managing file-based storage of user workout data.
 * This class provides methods to:
 * - Check if the storage file exists
 * - Create the storage file and its parent directories if necessary
 * - Write serialized data to the file
 * - Register WorkoutDTO objects by serializing and saving them
 */
public class FileManager {

    /** Path to the file where serialized workout data is stored. */
    private final String baseDirectory = AppConstants.USER_WORKOUT_DATA_PATH;

    /** Serializer used to convert objects into JSON strings. */
    private final JsonSerializer jsonSerializer = new JsonSerializer();

    /**
     * Checks whether the storage file exists and is not a directory.
     *
     * @return true if the file exists and is a regular file; false otherwise
     */
    private boolean checkIfFileExists() {
        File filePath = new File(baseDirectory);
        return filePath.exists() && !filePath.isDirectory();
    }

    /**
     * Creates the storage file at the location defined by baseDirectory.
     * If the file already exists, no action is taken.
     * Creates parent directories if they do not exist.
     *
     * @return true if the file was successfully created; false otherwise
     */
    private boolean createStorageFile() {
        File filePath = new File(baseDirectory);

        try {
            File parentDir = filePath.getParentFile();

            if (this.checkIfFileExists()) {
                return false;
            }

            if (!parentDir.exists() && !parentDir.mkdirs()) {
                System.err.println("Couldn't create directories.");
                return false;
            }

            return filePath.createNewFile();

        } catch (IOException ioException) {
            System.err.println("Error creating file: " + ioException.getMessage());
            return false;
        }
    }

    /**
     * Writes the given content to the storage file.
     * If the file does not exist, it will be created first.
     * Adds a comma and newline before the content to support appending in JSON array format.
     *
     * @param contents The content to write, typically a JSON string
     * @return true if the content was successfully written; false if an error occurred
     */
    private boolean writeToFile(String contents) {
        File file = new File(baseDirectory);

        try {
            if (!file.exists() && !createStorageFile()) {
                System.err.println("Couldn't create storage file.");
                return false;
            }

            try (BufferedWriter storageFile = new BufferedWriter(new FileWriter(file, true))) {
                storageFile.write(contents);

                return true;
            }

        } catch (IOException ioException) {
            System.err.println("Error writing to file: " + ioException.getMessage());
            return false;
        }
    }

    /**
     * Serializes a WorkoutDTO object and appends it to the storage file.
     *
     * @param objectToSerialize The workout object to serialize and save
     */
    public void registerSerializedWorkout(WorkoutDTO objectToSerialize) {
        if (this.writeToFile(jsonSerializer.serialize(objectToSerialize))) {
            System.out.println("Successfully serialized and registered workout");
        }
    }
}
