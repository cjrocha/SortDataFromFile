package ro.siit.java8;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class WriteOutput {

    /**
     * Writes the sorted list of persons into an
     * output file.
     * @param fileName - the absolute path to output file
     * @param sortedPersons - the sorted list generated by SortInput class.
     */
    static void writerOfOutput(String fileName, List<Person> sortedPersons) {
        Logger logger = Logger.getLogger("log.txt");
        Path pathToFile = Paths.get(fileName);
        try (FileOutputStream fis2 = new FileOutputStream(String.valueOf(pathToFile));
             OutputStreamWriter isr2 = new OutputStreamWriter(fis2, "UTF-8");
             BufferedWriter bf = new BufferedWriter(isr2)) {
            sortedPersons.stream()
                    .forEach(x-> {
                        try {
                            bf.write(String.valueOf(x));
                            logger.info("All went perfectly! Now output file is ready!");
                        } catch (IOException e) {
                            logger.severe("Unable to write the data!");
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            logger.severe("Writer had a problem! The data was not witten to output file!");
            e.printStackTrace();
        }
    }
}
