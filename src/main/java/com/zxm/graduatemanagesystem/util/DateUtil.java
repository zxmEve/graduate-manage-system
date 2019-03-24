package com.zxm.graduatemanagesystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zwp on 17/1/20.
 */
public class DateUtil {


    public final static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日HH时");
    public final static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy年MM月dd日");
    public final static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM");
    public final static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    public final static SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
    public final static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
    public final static SimpleDateFormat sdf9 = new SimpleDateFormat("yyyy-MM-dd HH:59:59");
    public final static SimpleDateFormat sdf0 = new SimpleDateFormat("2000-MM-dd");// 闰年，不会出现无法转化2.29的情况
    public final static SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy/MM/dd");
    public final static SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy/MM/dd HH:00");
    public final static SimpleDateFormat sdf13 = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat sdf14 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public final static SimpleDateFormat sdf15 = new SimpleDateFormat("HH:mm");

    public static String formatSeconds(Long seconds){
        StringBuilder stringBuilder = new StringBuilder();
        long hour = seconds / 60 / 60;
        long minute = seconds % 3600 / 60;
        long second = seconds % 60;
        stringBuilder.append(hour + "小时" + minute + "分钟" + second + "秒");
        return stringBuilder.toString();
    }



    public static Date addDay(Date date, int count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, count);
        return cal.getTime();
    }

    public static Date addYear(Date date, int count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, count);
        return cal.getTime();
    }

    public static Date addMonth(Date date, int count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, count);
        return cal.getTime();
    }

    public static Date getCertainHourDate(Date date, int setHour) {
        Calendar halfDate = Calendar.getInstance();
        halfDate.setTime(date);
        halfDate.set(Calendar.HOUR_OF_DAY, setHour);
        halfDate.set(Calendar.MINUTE, 0);
        halfDate.set(Calendar.SECOND, 0);
        halfDate.set(Calendar.MILLISECOND, 0);
        return halfDate.getTime();
    }

    //计算两个日期相差年数
    public static int yearsBetween(Date startDate, Date endDate) {
        Date formatStartDate = null;
        Date formatEndDate = null;
        try {
            formatStartDate = sdf1.parse(sdf1.format(startDate));
            formatEndDate = sdf1.parse(sdf1.format(endDate));
        } catch (ParseException e) {
//            throw new ServiceException(BaseErrorCode.INTERNAL_ERROR.getCode(), "日期转换出错");
            e.printStackTrace();
        }

        Calendar calBegin = Calendar.getInstance(); //获取日历实例
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(formatStartDate); //字符串按照指定格式转化为日期
        calEnd.setTime(formatEndDate);
        int diffYears = calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
        calBegin.add(Calendar.YEAR, diffYears);
        if (!calBegin.before(calEnd)) {
            diffYears = diffYears - 1;
        }
        return diffYears;
    }

    //计算两个日期相差天数
    public static int daysBetween(Date startDate, Date endDate) {
        Calendar calBegin = Calendar.getInstance(); //获取日历实例
        calBegin.setTime(startDate);
        calBegin.set(Calendar.HOUR_OF_DAY, 0);
        calBegin.set(Calendar.MINUTE, 0);
        calBegin.set(Calendar.SECOND, 0);
        calBegin.set(Calendar.MILLISECOND, 0);

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);
        calEnd.set(Calendar.HOUR_OF_DAY, 0);
        calEnd.set(Calendar.MINUTE, 0);
        calEnd.set(Calendar.SECOND, 0);
        calEnd.set(Calendar.MILLISECOND, 0);

        Long betweenDays = (calEnd.getTimeInMillis() - calBegin.getTimeInMillis()) / (1000 * 3600 * 24);
        return betweenDays.intValue();
    }

    // 计算两个日期相差小时数
    public static int hoursBetween(Date startDate, Date endDate){
        LocalDateTime startLocalTime = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime endLocalTime = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
        Long hours = ChronoUnit.HOURS.between(startLocalTime,endLocalTime);
        return hours.intValue();
    }

    public static int getYear(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.get(ChronoField.YEAR);
    }

    public static int getDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.get(ChronoField.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.get(ChronoField.MONTH_OF_YEAR);
    }

    public static int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.get(ChronoField.HOUR_OF_DAY);
    }


    /**
     * 获取指定月份开始日期
     * @param month
     * @return
     * @throws ParseException
     */
    public static Date getMonthStartDate(String month) throws ParseException {
        Calendar cal = null;
        if (month != null) {
            cal = Calendar.getInstance();//获取当前日期
            cal.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            cal = Calendar.getInstance();
            cal.setTime(sdf5.parse(month));
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTime();
    }

    /**
     * 获取指定月份结束日期
     * @param month
     * @return
     * @throws ParseException
     */
    public static Date getMonthEndDate(String month) throws ParseException {
        Calendar cal = null;

        if (month != null) {
            cal = Calendar.getInstance();
        } else {
            cal = Calendar.getInstance();
            cal.setTime(sdf5.parse(month));
        }
        int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, endDay);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cal.set(Calendar.MILLISECOND,999);
        return cal.getTime();
    }

    /**
     * 获取当前月份起始日期
     * @return
     */
    public static Date getMonthStartDate(){
        Calendar calendar = Calendar.getInstance();
        int start = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        Calendar startDate = calendar;
        startDate.set(Calendar.HOUR_OF_DAY, 0);
        startDate.set(Calendar.MINUTE, 0);
        startDate.set(Calendar.SECOND, 0);
        startDate.set(Calendar.DAY_OF_MONTH,start);
        return startDate.getTime();
    }

    /**
     * 获取当前月份结束日期
     * @return
     */
    public static Date getMonthEndDate(){
        Calendar calendar = Calendar.getInstance();
        int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar endDate = calendar;
        endDate.set(Calendar.HOUR_OF_DAY, 23);
        endDate.set(Calendar.MINUTE, 59);
        endDate.set(Calendar.SECOND, 59);
        endDate.set(Calendar.DAY_OF_MONTH,end);
        return endDate.getTime();
    }
    /**
     * 获取当前日开始时间
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前日结束时间
     * @return
     */
    public static Date getEndTimeOfDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);
        Date dayEnd = calendar.getTime();
        return dayEnd;
    }

    public static Date getDate(int year, int month, int day) {
        ZoneId zone = ZoneId.systemDefault();
        LocalDate clearLocalDate = LocalDate.of(year, month, day);
        return Date.from(clearLocalDate.atStartOfDay().atZone(zone).toInstant());
    }

    /**
     * 获取下一天年假的日期
     *
     * @param joinKeepTime   入职Keep日期
     * @param currDate       当前日期
     * @param annualThisYear 年假天数
     * @return
     */
    public static Date getNextAnnualDate(Date joinKeepTime, Date currDate, int annualThisYear) {
        Date keepYearStartDate = getKeepYearStartDate(joinKeepTime, currDate);
        int diffDays = daysBetween(keepYearStartDate, currDate) + 1; // 算头也算尾
        int slots = 0;
        for (int i = 1; i <= annualThisYear; i++) {
            Double ceil = Math.ceil((365.0 * i) / annualThisYear);
            slots = ceil.intValue();
            if (slots < diffDays) {
                continue;
            } else {
                break;
            }
        }
        return addDay(keepYearStartDate, slots - 1);
    }

    /**
     * 获取员工入职年开始时间（如2016年1月1日入职，当前时间2018年3月3日，则当前Keep入职年开始时间是2017年12月31日（365天一周年））
     *
     * @param joinKeepTime 入职Keep日期
     * @param currDate     当前日期
     * @return
     */
    public static Date getKeepYearStartDate(Date joinKeepTime, Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(joinKeepTime);
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date startDate = cal.getTime();
        while (cal.getTime().before(currDate)) {
            startDate = cal.getTime();
            cal.add(Calendar.DAY_OF_YEAR, 365);
        }
        return startDate;
    }

    /**
     * 获取员工入职年结束时间（如2016年1月1日入职，当前时间2018年3月3日，则当前Keep入职年结束时间是2018年12月31日（365天一周年））
     *
     * @param joinKeepTime 入职Keep日期
     * @param currDate     当前日期
     * @return
     */
    public static Date getKeepYearEndDate(Date joinKeepTime, Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(joinKeepTime);
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date endDate;
        while ((endDate = cal.getTime()).before(currDate)) {
            cal.add(Calendar.DAY_OF_YEAR, 365);
        }
        return endDate;
    }

    /**
     * 获得keep考勤月开始的时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getKeepMonthStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        if (cal.get(Calendar.DAY_OF_MONTH) < 26) {
            cal.add(Calendar.MONTH, -1);
        }
        cal.set(Calendar.DAY_OF_MONTH, 26);
        return cal.getTime();
    }

    /**
     * 获得keep考勤月开始的时间
     *
     * @return
     * @throws ParseException
     */
    public static Date getKeepMonthStartDate() {
        return getKeepMonthStartDate(new Date());
    }

    /**
     * 获得keep考勤月结束的时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getKeepMonthEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        if (cal.get(Calendar.DAY_OF_MONTH) >= 26) {
            cal.add(Calendar.MONTH, 1);
        }
        cal.set(Calendar.DAY_OF_MONTH, 26);

        return cal.getTime();
    }

    public static Date getKeepDayStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 将分秒,毫秒域清零
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        cal.set(Calendar.HOUR_OF_DAY, 10);

        return cal.getTime();
    }

    public static Date getKeepDayEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 将分秒,毫秒域清零
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        cal.set(Calendar.HOUR_OF_DAY, 19);

        return cal.getTime();
    }

    /**
     * 获得keep考勤月结束的时间
     *
     * @return
     * @throws ParseException
     */
    public static Date getKeepMonthEndDate() {
        return getKeepMonthEndDate(new Date());
    }

    public static void main(String[] args) throws ParseException {
        String joinKeepTime = "2018-1-1 12:59:59";
        Date joinKeepDate = sdf2.parse(joinKeepTime);
        String currTime = "2018-4-16 11:59:59";
        Date currDate = sdf2.parse(currTime);
        System.out.println(getNextAnnualDate(joinKeepDate, currDate, 7));
    }
}
