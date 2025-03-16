package com.feeder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JsonUtils {
    public static String readJsonFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON: " + filePath, e);
        }
    }
}
