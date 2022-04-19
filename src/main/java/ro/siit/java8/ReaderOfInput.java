package ro.siit.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReaderOfInput {

    /**
     * Read's data from csv input file
     * @param fileName - the absolute path to input file as string
     * @return - list of person's data read from input file
     */
    static List<Person> readPerson(String fileName) {
        Logger logger = Logger.getLogger("log.txt");
        List<Person> persons = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] entries = line.split(",");
                persons.add(new Person(entries[0], entries[1], entries[2]));
                line = br.readLine();
            }
            logger.info("File was read successfully");
        } catch (IOException ioe) {
            logger.severe("Something went wrong! The input file was not read!");
            ioe.printStackTrace();
        }
        return persons;
    }
}
