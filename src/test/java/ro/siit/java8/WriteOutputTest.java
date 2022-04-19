package ro.siit.java8;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteOutputTest {

    /**
     * Based on a given list of persons, tests if
     * sorting and filtering by month works and the output
     * is being correctly inserted into and output file.
     */
    @Test
    void writerOfOutput() {
        String fileName = "D:/Java-Dev/SortDataFromFile/src/main/resources/output.csv";
        Path pathToFile = Paths.get(fileName);
        try (FileOutputStream fis2 = new FileOutputStream(String.valueOf(pathToFile));
             OutputStreamWriter isr2 = new OutputStreamWriter(fis2, "UTF-8");
             BufferedWriter bf = new BufferedWriter(isr2)) {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("William", "Smith", "1999-10-09"));
            persons.add(new Person("Mark", "Sammon", "1980-12-24"));
            persons.add(new Person("Jill", "Kriger", "2000-10-19"));
            persons.add(new Person("Joe", "Doe", "1970-07-24"));
            persons.add(new Person("Jennie", "Whong", "1960-10-10"));
            persons.add(new Person("Mary", "J. Cathcart", "2005-08-13"));

            SortInput s = new SortInput();
            List<Person> results = s.sortData(persons);
            results.stream()
                    .filter(r -> r.getMonth().equals("10"))
                    .forEach(x -> {
                        try {
                            bf.write(String.valueOf(x)+"\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException ioe){
            ioe.getStackTrace();
        }
    }
}