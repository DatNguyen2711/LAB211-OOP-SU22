package Ccrm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Te {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy: " + strDate);
    }
}
