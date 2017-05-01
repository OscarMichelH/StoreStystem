package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Prueba {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        System.out.println(format.format(calendar.getTime()));

    }

}
