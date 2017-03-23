package poi.fillexcel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于日期类使用原则: 
 *
 * 所有的日期运算均使用java.util.Date类进行比较和增减运算，禁止直接使用字符串！
 * 需要字符串时，先转换为日期类型运算完毕再转换为字符串。避免产生太多的静态方法！
 *
 * @author Jim Wu
 *
 */
public class UtilDateTime {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String COMPACT_DATE_PATTERN = "yyyyMMdd";
    private static final String COMPACT_TIME_PATTERN = "HHmmss";
    private static final String MM_TIME_PATTERN = "HH:mm";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String MIL_PATTERN = "HH:mm:ss:SSS";

    /* ------------------------------  类型转换方法 --------------------------- */

    public static final String convertDateToString(Date aDate,String pattern) {
        return aDate == null ? null : (new SimpleDateFormat(pattern)).format(aDate);
    }

    public static final String convertDateToString(Date aDate) {
        return aDate == null ? null : (new SimpleDateFormat(DATE_PATTERN)).format(aDate);
    }

    public static Date convertStringToDate(String strDate) throws ParseException {
        return (new SimpleDateFormat(DATE_PATTERN)).parse(strDate);
    }

    public static final String convertDateToCompactString(Date aDate) {
        return aDate == null ? null : (new SimpleDateFormat(COMPACT_DATE_PATTERN)).format(aDate);
    }

    public static Date convertCompactStringToDate(String strDate) throws ParseException {
        return (new SimpleDateFormat(COMPACT_DATE_PATTERN)).parse(strDate);
    }

    public static final String convertTimeToCompactString(Date aDate) {
        return aDate == null ? null : (new SimpleDateFormat(COMPACT_DATE_PATTERN+COMPACT_TIME_PATTERN)).format(aDate);
    }

    public static Date convertCompactStringToTime(String strDate) throws ParseException {
        return (new SimpleDateFormat(COMPACT_DATE_PATTERN+COMPACT_TIME_PATTERN)).parse(strDate);
    }

    public static java.sql.Date convertStringToSqlDate(String strDate) throws ParseException {
        return new java.sql.Date((new SimpleDateFormat(DATE_PATTERN)).parse(strDate).getTime());
    }

    public static final String convertMmTimeToString(Date aTime) {
        return aTime == null ? null : (new SimpleDateFormat(MM_TIME_PATTERN)).format(aTime);
    }

    public static Date convertStringToMmTime(String strMmTime) throws ParseException {
        return new Date((new SimpleDateFormat(MM_TIME_PATTERN)).parse(strMmTime).getTime());
    }

    public static final String convertDateTimeToString(Date aDateTime) {
        return aDateTime == null ? null : (new SimpleDateFormat(DATE_PATTERN + " " + TIME_PATTERN)).format(aDateTime);
    }

    public static final String convertDateTimeToMilString(Date aDateTime) {
        return aDateTime == null ? null : (new SimpleDateFormat(DATE_PATTERN + " " + MIL_PATTERN)).format(aDateTime);
    }

    public static final String convertDateTimeToMmString(Date aDateTime) {
        return aDateTime == null ? null : (new SimpleDateFormat(DATE_PATTERN + " " + MM_TIME_PATTERN)).format(aDateTime);
    }

    public static final Date convertMmStringToDateTime(String strMmDateTime) throws ParseException {
        return new Date((new SimpleDateFormat(DATE_PATTERN + " " + MM_TIME_PATTERN)).parse(strMmDateTime).getTime());
    }

    public static Date convertStringToDateTime(String strDateTime) throws ParseException {
        return new Date((new SimpleDateFormat(DATE_PATTERN + " " + TIME_PATTERN)).parse(strDateTime).getTime());
    }

    public static Date convertStringToDateTime(String datePattern,String strDateTime)  {
        try {
            return new Date((new SimpleDateFormat(datePattern)).parse(strDateTime).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* -----------------------------  以下是日期运算方法 --------------------------- */

    public static Date getYearStartTime(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);
        return getMonthStartTime(calendar);
    }

    public static Date getYearEndTime(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 11);
        return getMonthEndTime(calendar);
    }

    public static Date getMonthEndTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);

        tmpCalendar.add(Calendar.MONTH, 1);
        tmpCalendar.add(Calendar.MILLISECOND, -1);
        return tmpCalendar.getTime();
    }

    public static Date getMonthEndTime(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return getMonthEndTime(calendar);
    }

    public static Date getMonthEndTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getMonthEndTime(calendar);
    }

    public static Date getMonthStartTime(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return getMonthStartTime(calendar);
    }

    public static Date getMonthStartTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);
        return tmpCalendar.getTime();
    }

    public static Date getMonthStartTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getMonthStartTime(calendar);
    }

    public static Date getDayEndTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);

        tmpCalendar.add(Calendar.DATE, 1);
        tmpCalendar.add(Calendar.MILLISECOND, -1);
        return tmpCalendar.getTime();
    }

    public static Date getDayEndTime(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return getDayEndTime(calendar);
    }

    public static Date getDayEndTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDayEndTime(calendar);
    }

    public static Date getDayEndTime(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(UtilDateTime.convertStringToDateTime(DATE_PATTERN, date));
        return getDayEndTime(calendar);
    }

    public static Date getDayStartTime(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return getDayStartTime(calendar);
    }

    public static Date getDayStartTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);
        return tmpCalendar.getTime();
    }

    public static Date getDayStartTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDayStartTime(calendar);
    }

    public static Date getDayStartTime(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(UtilDateTime.convertStringToDateTime(DATE_PATTERN, date));
        return getDayStartTime(calendar);
    }

    public static Date getWeekStartTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);
        tmpCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        tmpCalendar.set(Calendar.DAY_OF_WEEK, tmpCalendar.getFirstDayOfWeek());
        return tmpCalendar.getTime();
    }
    
    public static Date getWeekStartTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getWeekStartTime(calendar);
    }

    public static Date getWeekEndTime(Calendar calendar){
        Calendar tmpCalendar = (Calendar)calendar.clone();
        tmpCalendar.set(Calendar.HOUR_OF_DAY, 0);
        tmpCalendar.set(Calendar.MINUTE, 0);
        tmpCalendar.set(Calendar.SECOND, 0);
        tmpCalendar.set(Calendar.MILLISECOND, 0);
        tmpCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        tmpCalendar.set(Calendar.DAY_OF_WEEK, tmpCalendar.getFirstDayOfWeek());
        tmpCalendar.add(Calendar.DATE, 7);
        tmpCalendar.set(Calendar.MILLISECOND, -1);
        return tmpCalendar.getTime();
    }
    
    public static Date getWeekEndTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getWeekEndTime(calendar);
    }

    //---------------------------------------------------------
    
    public static Date getCurentWeekStartTime() {
        return getWeekStartTime(new Date());
    }

    public static Date getCurentWeekEndTime() {
        return getWeekEndTime(new Date());
    }

    public static Date getCurentMonthStartTime() {
        return getMonthStartTime(new Date());
    }

    public static Date getCurentMonthEndTime() {
        return getMonthEndTime(new Date());
    }


    /**
     * 计算两个日期之间相差的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*60*60*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的小时
     * @param date1
     * @param date2
     * @return
     */
    public static int hoursBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*60*60);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的分钟
     * @param date1
     * @param date2
     * @return
     */
    public static int minutesBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*60);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的秒钟
     * @param date1
     * @param date2
     * @return
     */
    public static int secondsBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的秒钟
     * @param date1
     * @param date2
     * @return
     */
    public static String timeBetween(Date date1,Date date2) {
        return daysBetween(date1, date2) + "天" + hoursBetween(date1, date2) % 24 + "时" + minutesBetween(date1, date2) % 60 + "分" + secondsBetween(date1, date2) % 60 + "秒";
    }

    /**
     * 比较日期是否在 期间
     * @param startDate
     * @param endDate
     * @param compareDate
     * @return
     */
    public static boolean  between(Date startDate,Date endDate,Date compareDate){
        if(startDate==null||endDate==null||compareDate==null){
            return false;
        }

        return  (startDate.before(compareDate)||startDate.equals(compareDate))
                &&(compareDate.before(endDate)||compareDate.equals(endDate));
    }

    /**
     * 判断两个日期是否同一天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean sameDay(Date d1, Date d2){
        if (d1 == null || d2 == null){
            return false;
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
               c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) &&
               c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }

}
