package org.example;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первую дату в формате дд.мм.гггг: ");
        String inputDate1 = scanner.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date date1;
        try {
            date1 = dateFormat.parse(inputDate1);
        } catch (ParseException e) {
            System.out.println("Ошибка");
            return;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_YEAR, 45);
        Date newDate1 = calendar1.getTime();
        System.out.println(dateFormat.format(newDate1));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date1);
        calendar2.set(Calendar.DAY_OF_YEAR, 1);
        Date newDate2 = calendar2.getTime();
        System.out.println(dateFormat.format(newDate2));
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date1);
        int workDays = 5;
        while (workDays < 10) {
            calendar3.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = calendar3.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
        }
        Date newDate3 = calendar3.getTime();
        System.out.println(dateFormat.format(newDate3));
        System.out.print("Введите вторую дату в формате дд.мм.гггг: ");
        String inputDate2 = scanner.nextLine();
        Date date2;
        try {
            date2 = dateFormat.parse(inputDate2);
        } catch (ParseException e) {
            System.out.println("Ошибка");
            return;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date1);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(date2);
        int workDaysBetween = 0;
        while (startCalendar.before(endCalendar)) {
            startCalendar.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDaysBetween++;
            }
        }
        System.out.println(workDaysBetween);
    }
}