// Write a program to print todays date in the format Day MMM DD hr.min.sec TIMEZONE YYYY [Ex: Fri Aug 01 16:16:27 IST 2008] using date format .
// Use SimpleDateFormat class to format the date to specified format.

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeZone {
    public static void main(String[] args){
        // LocalDateTime localDateTime=LocalDateTime.now();
        // System.out.println(localDateTime.getDayOfWeek()+" "+localDateTime.getMonth()+" "+localDateTime.getDayOfMonth()+" "+localDateTime.getHour()+":"+localDateTime.getMinute()+":"+localDateTime.getSecond()+" "+localDateTime.getChronology()+" "+localDateTime.getYear() );
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("E MMM dd HH:mm:ss z yyy");
        String str=simpleDateFormat.format(date);
        System.out.println(str);

        // SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("dd/MM/yyyy");
        // try{
        //     Date date2=simpleDateFormat2.parse("03/06/2024");
        //     System.out.println(date2);
        // }
        // catch(Exception e){
        //     System.out.println("Error : "+e);
        // } 
    }
}
