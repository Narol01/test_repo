package homework;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateOperation {
    public static int getAge(String birthDate) {
        LocalDate date = LocalDate.parse(birthDate);
        System.out.println(date);
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        long age = ChronoUnit.YEARS.between(date, currentDate);
        System.out.println(age);
        return (int) age;
    }

    public static String[] sortStringDates(String[] dates) {
       return null;
    }
}
