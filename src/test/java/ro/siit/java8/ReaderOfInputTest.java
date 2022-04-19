package ro.siit.java8;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;


class ReaderOfInputTest {
    /**
     * Testing if input file is found and read correctly.
     */
    @Test
    void readPerson() {
        //expected
        String expected = "Reading is done successfully";
        //actual
        String fileName = "D:/Java-Dev/SortDataFromFile/src/main/resources/input.csv";
        Path pathToFile = Paths.get(fileName);
        String response = null;
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            response = "Reading is done successfully";
        } catch (IOException e) {
            e.getStackTrace();
        }
        assertEquals(expected, response);
    }
}