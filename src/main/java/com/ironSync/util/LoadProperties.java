package com.ironSync.util;

import com.ironSync.config.AppConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public String[] loadDbProperties() {
        Properties dbProperties = new Properties();

        try(InputStream propsFile = getClass().getClassLoader().getResourceAsStream(AppConstants.DATABASE_PROPERTIES_PATH)) {
            if (propsFile == null) {
                throw new IllegalArgumentException("No se encontró el archivo " + AppConstants.DATABASE_PROPERTIES_PATH);
            }

            dbProperties.load(propsFile);
            String[] allDbProperties = new String[3];

            allDbProperties[0] = dbProperties.getProperty("db.url");
            allDbProperties[1] = dbProperties.getProperty("db.user");
            allDbProperties[2] = dbProperties.getProperty("db.password");

            return allDbProperties;
        }catch (IOException ioEx) {
                throw new IllegalArgumentException("An IO error ocurred while loading the database properties" + ioEx);
        } catch (Exception e) {
            throw new IllegalArgumentException("An error ocurred while loading the database properties" + e);
        }
    }
}
