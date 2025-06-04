package com.ironSync.storage;

import com.ironSync.util.ObjectUtils;
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
    private String baseDirectory;

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
        try (FileWriter storageFile = new FileWriter(baseDirectory)) {
            storageFile.write(contents);
            return true;
        } catch (IOException ioException) {
            System.err.println("Error writing to file: " + ioException.getMessage());
            return false;
        }
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
