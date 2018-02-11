package com.jinke.cstsearch.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateManager {

    public static String getCurrentTime(String sdf) {
        Date now = new Date();
        return formatDate(now, sdf);
    }

    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date, String sdf) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf);
        return simpleDateFormat.format(date);
    }

    /**
     * 比较两个时间，返回相差的秒数（前者减后者）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long compareTime(Date date1, Date date2) {
        return (date1.getTime() - date2.getTime()) / 1000;
    }

    public static long compareTimetoString(Date date1, String dateString2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date2 = sdf.parse(dateString2);
            return compareTime(date1, date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static long compareTime(String dateString1, String dateString2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse(dateString1);
            Date date2 = sdf.parse(dateString2);
            return compareTime(date1, date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param standard YEAR
     * @param value
     * @return
     */
    public static String getSpecificTime(String standard, int value) {

        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        if ("YEAR".equals(standard)) {
            calendar.add(Calendar.YEAR, value);
            date = calendar.getTime();
            return formatDate(date, "yyyy-MM-dd HH:mm:ss");
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        //String s = DateManager.getSpecificTime("YEAR", (-1) * 1).substring(0,10);
        //s = getCurrentTime("yyyy-MM-dd");
        String s = getCurrentTime();

        System.out.println(s);
    }
}
