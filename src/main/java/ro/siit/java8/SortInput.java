package ro.siit.java8;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SortInput {

    /**
     * Using Java8 streams and lambda expressions
     * sorts the input data by month and first person name.
     * @param persons - list of persons data from input file
     * @return - sorted list of persons
     */
    public List<Person> sortData (List<Person> persons){
        Logger logger = Logger.getLogger("log.txt");
        List<Person> finalSortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getFname))
                .sorted(Comparator.comparing(Person::getMonth))
                .collect(Collectors.toList());
        logger.info("All good! The data was sorted by month & fist name!");
        return finalSortedPersons;
    }
}
