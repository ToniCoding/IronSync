package com.ironSync.storage;

import com.ironSync.config.AppConstants;
import com.ironSync.dto.WorkoutDTO;
import com.ironSync.util.ObjectUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that handles data storage operations in files.
 * Provides methods for checking if a file exists, creating a storage file,
 * writing data to a file, and registering serialized objects in a file.
 */
public class FileManager {

    /** The base directory where the storage file is saved. */
    private final String baseDirectory = AppConstants.USER_WORKOUT_DATA_PATH;
    private final JsonSerializer jsonSerializer = new JsonSerializer();

    /** Indicates if the storage should have a pretty-print format (not used in this code). */
    private boolean prettyPrint;

    /**
     * Checks if the storage file exists in the specified location.
     *
     * @return true if the file exists and is not a directory, false otherwise.
     */
    private boolean checkIfFileExists() {
        File filePath = new File(baseDirectory);
        return filePath.exists() && !filePath.isDirectory();
    }

    /**
     * Creates a new file at the location specified by {@code baseDirectory}.
     * If the file already exists, no action is performed.
     *
     * @return true if the file is created successfully, false if it could not be created.
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
     * Writes the provided contents to the file specified by {@code baseDirectory}.
     *
     * @param contents The contents to write to the file.
     * @return true if the data is written successfully, false if an error occurred.
     */
    private boolean writeToFile(String contents) {
        File file = new File(baseDirectory);

        try {
            if (!file.exists() && !createStorageFile()) {
                System.err.println("Couldn't create storage file.");
                return false;
            }

            try (BufferedWriter storageFile = new BufferedWriter(new FileWriter(file, true))) {
                storageFile.write(",");
                storageFile.newLine();
                storageFile.write(contents);

                return true;
            }

        } catch (IOException ioException) {
            System.err.println("Error writing to file: " + ioException.getMessage());
            return false;
        }
    }

    public void registerSerializedWorkout(WorkoutDTO objectToSerialize) {
        this.writeToFile(jsonSerializer.serialize(objectToSerialize));
    }

    /**
     * Registers the serialized data of the provided object in a file.
     * First, it serializes the object to JSON format and then writes the JSON to the storage file.
     *
     * @param objectToSave The object to be saved.
     * @return true if the data is registered successfully, false if an error occurred.
     */
    public boolean registerData(Object objectToSave) {
        ObjectUtils objectUtils = new ObjectUtils();
        String serializedObject = objectUtils.objectSerialization(objectToSave);

        if (!writeToFile(serializedObject)) {
            System.err.println("Error writing data to file.");
            return false;
        }

        return true;
    }
}
