package com.edison.datetime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author ${Administrator}
 * @description 日期处理类
 * @create 2017-10-19 15:04
 **/
public class CalenderTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        getDateTime(calendar);
        getCurrentMilliSecond();
        getMonthLastDay(calendar);
        getYesterdayNowTime();
    }

    /**
     * //如何取得某个日期是当月的最后一天
     * @param calendar
     */
    private static void getMonthLastDay(Calendar calendar) {
        System.out.println("如何取得某个日期是当月的最后一天====================================================");
        calendar.add(Calendar.MONTH, -1);
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    /**
     *   //如何取得从1970 年到现在的毫秒数？
     */
    private static void getCurrentMilliSecond() {
        System.out.println("如何取得从1970 年到现在的毫秒数====================================================");
        System.out.println(Calendar.getInstance().getTimeInMillis() + "\t" + System.currentTimeMillis());
    }

    /**
     *  //如何取得年月日、小时分秒？
     * @param calendar
     */
    private static void getDateTime(Calendar calendar) {
        System.out.println("如何取得年月日、小时分秒====================================================");
        System.out.print(calendar.get(Calendar.YEAR));
        System.out.print(calendar.get(Calendar.MONTH) + 1);
        System.out.print(calendar.get(Calendar.DATE));
        System.out.print(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.print(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
    }

    /**
     * 打印昨天的当前时刻
     * @return
     */
    public static String getYesterdayNowTime() {
        System.out.println("打印昨天的当前时刻====================================================");
        Date todayNow = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayNow);
        calendar.add(calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动
        todayNow = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yesterdayNow = formatter.format(todayNow);
        System.out.println(yesterdayNow);
        return yesterdayNow;
    }

    public static Date stringToDate() {
        String str = "2014-07-09 10:48:23";
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
        return d;
    }
}
