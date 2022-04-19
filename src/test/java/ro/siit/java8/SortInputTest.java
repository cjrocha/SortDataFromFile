package ro.siit.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortInputTest {

    /**
     * Based on Java8's streams and lambda expressions
     * tests the sorting of person's first name that were
     * birth in a given month
     */
    @Test
    void sortData() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("William", "Smith", "1999-10-09"));
        persons.add(new Person("Mark", "Sammon", "1980-10-24"));
        persons.add(new Person("Jill", "Kriger", "2000-10-19"));
        persons.add(new Person("Joe", "Doe", "1970-07-24"));
        persons.add(new Person("Jennie", "Whong", "1960-10-10"));
        persons.add(new Person("Mary", "J. Cathcart", "2005-08-13"));

        SortInput s = new SortInput();
        List<Person> results = s.sortData(persons);
        results.stream()
                .filter(r -> r.getMonth().equals("10"))
                .forEach(System.out::println);
    }
}