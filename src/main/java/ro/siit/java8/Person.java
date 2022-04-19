package ro.siit.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Person {
    String fname;
    String lname;
    String dateOfBirth;

    /**
     * Constructor for object entry from input file
     * validates that date is correct format.
     * @param fname - first name of entry
     * @param lname - last name of entry
     * @param dateOfBirth - date of birth of entry
     */
    public Person(String fname, String lname, String dateOfBirth) {
        Logger logger = Logger.getLogger("log.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.fname = fname;
        this.lname = lname;
        try{
            Date d = sdf.parse(dateOfBirth);
        } catch (ParseException e) {
            logger.severe("Error in Date of birth format!\nPlease use this format: 'yyyy-mm-dd'");
            e.printStackTrace();
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getFname() {
        return fname;
    }

    /**
     * This methode extracts the month from person date of birth,
     * that will be used for retrieving the sorted list of persons
     * born in a given month.
     * @return - month of birth
     */
    public String getMonth(){
        String[] dates = this.dateOfBirth.split("-");
        String month = dates[1];
        return month;
    }

    @Override
    public String toString() {
        return "firstname='" + fname + '\'' +
                ", lastname='" + lname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
