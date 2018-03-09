package ro.siit.concedii;

import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);

        Date older = new Date();
        older.setYear(1980);

        long i = today.getTime().getYear() - older.getYear();

        System.out.println(i);
        System.out.println(today);
        System.out.println(older);

    }

}


