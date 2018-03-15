package ro.siit.concedii;


import java.time.*;
import java.util.Date;

public class Main {
    public static LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

    public static LocalDate addworkingDays(Date date, int days){
        LocalDate lday = getLocalDateFromDate(date);
        if (days < 1 ){
            return lday;
        }
        LocalDate result = lday;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }


        return result;
    }

    public static Date localDateasDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate inthepast = getLocalDateFromDate( new Date(80,12,8));
//        System.out.println(now.getYear() - inthepast.getYear());


        LocalDate test = addworkingDays(new Date(117,3,15),10);
        System.out.println(test.getDayOfMonth());
        System.out.println(localDateasDate(now));
    }

}


