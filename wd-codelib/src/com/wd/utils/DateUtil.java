package com.wd.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * 日期工具类
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年1月13日
 * @see        
 * 
 */
public class DateUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private DateUtil(){}
	
	
	/**
	 * 返回当前10位时间戳
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int now() {
		return currentSecond();
	}
	
	/**
	 * @param timeint
	 * @return
	 */
	public static final String second2DateStr(Integer timeint) {
		if (timeint == null) {
			return "N/A";
		}
		long timelong = timeint * 1000l;
		Date date = new Date(timelong);
		return DateFormatUtils.format(date, DATE_FORMAT);
	}
	
	/**
	 * 时间戳（秒）转为日期字符串
	 * @param timeint
	 * @return
	 */
	public static final int date2Second(Date date) {
		if (date == null)
			return 0;
		return (int)(date.getTime() / 1000);
	}
	
	/**
	 * 字符串转为日期
	 * @param datestr
	 * @return
	 */
	public static final Date toDate(String datestr) {
		try {
			return DateUtils.parseDate(datestr, new String[]{DATE_FORMAT});
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 日期字符串转换为unix时间戳
	 * @param dateStr
	 * @return
	 */
	public static final int dateStr2Second(String dateStr) {
		return date2Second(toDate(dateStr));
	}
	
	/**
	 * 日期字符串转换为unix时间戳
	 * @param dateStr
	 * @return
	 */
	public static final int dateTimeStr2Second(String dateTimeStr) {
		return date2Second(toDateTime(dateTimeStr));
	}
	/**
	 * 字符串转为日期
	 * @param datestr
	 * @return
	 */
	public static final Date toDateTime(String datestr) {
		try {
			return DateUtils.parseDate(datestr, new String[]{DATETIME_FORMAT});
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 时间戳（秒）转为详细字符串
	 * @param timeint
	 * @return
	 */
	public static final String second2DateTimeStr(Integer timeint) {
		if (timeint == null) {
			return "N/A";
		}
		long timelong = timeint * 1000l;
		Date date = new Date(timelong);
		return  DateFormatUtils.format(date, DATETIME_FORMAT);
	}
	
	/**
	 * 获取当前系统时间的unix时间戳（秒）
	 * @return
	 */
	public static final int currentSecond() {
		long tmp = System.currentTimeMillis();
		return (int)(tmp/1000);
	}
	
	/**
	 * 获取两个日期之间的天数
	 * @author yang_huidi
	 * @param startDate
	 * @param endDate
	 * @return  
	 */
	
	public static final int getDaysBetweenTwoDate(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		return (DateUtil.date2Second(endDate) - DateUtil.date2Second(startDate)) / (24 * 3600);
	}

	/**
	 * 获取两个日期(秒数)之间的天数
	 * @author yang_huidi
	 * @param startDate
	 * @param endDate
	 * @return  
	 */
	
	public static final int getDaysBetweenTwoDate(int startTime, int endTime) {
		if (endTime <=0 || startTime <= endTime) {
			return 0;
		}
		return (endTime - startTime) / (24 * 3600);
	}
	/**
	 * 获取今天开始时间10位时间戳
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int currentDayStartSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取今天结束时间10位时间戳
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int currentDayEndSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	/**
	 * 获取本周开始时间10位时间戳
	 * @author yang_huidi
	 * @return
	 */
	public static final int currentWeekStartSecond() {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//周日的话，周需要-1
		if (dayOfWeek == 1) {
			cal.add(Calendar.WEEK_OF_YEAR, -1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取本周结束时间10位时间戳
	 * @author yang_huidi
	 * @return
	 */
	
	public static final int currentWeekEndSecond() {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//不是周日的话，设置成周日，并且周+1
		if (dayOfWeek != 1) {
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			cal.add(Calendar.WEEK_OF_YEAR, 1);
		}
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取本月开始时间10位时间戳
	 * @author yang_huidi
	 * @return
	 */
	public static final int currentMonthStartSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取本月结束时间10位时间戳
	 * @author yang_huidi
	 * @return
	 */
	
	public static final int currentMonthEndSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的当天的起始时间
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int getCurrentDayStartSecond(int timeSecond) {
		if (timeSecond <= 0)
			return 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的下一天的结束时间
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int getCurrentDayEndSecond(int timeSecond) {
		if (timeSecond <= 0)
			return 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的当周的起始时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getCurrentWeekStartSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//周日的话，周需要-1
		if (dayOfWeek == 1) {
			cal.add(Calendar.WEEK_OF_YEAR, -1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的当周的结束时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getCurrentWeekEndSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//不是周日的话，设置成周日，并且周+1
		if (dayOfWeek != 1) {
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			cal.add(Calendar.WEEK_OF_YEAR, 1);
		}
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	/**
	 * 获取时间戳timeSecond的当月的起始时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getCurrentMonthStartSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的当月的结束时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getCurrentMonthEndSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	/**
	 * 获取时间戳timeSecond的下一天的起始时间
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int getNextDayStartSecond(int timeSecond) {
		if (timeSecond <= 0)
			return 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond+86400)*1000L));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的下一天的结束时间
	 * @author yang_huidi
	 * @return  
	 */
	
	public static final int getNextDayEndSecond(int timeSecond) {
		if (timeSecond <= 0)
			return 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond+86400)*1000L));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的下一周的起始时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getNextWeekStartSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond+86400*7)*1000L));
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//周日的话，周需要-1
		if (dayOfWeek == 1) {
			cal.add(Calendar.WEEK_OF_YEAR, -1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的下一周的结束时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getNextWeekEndSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond+86400*7)*1000L));
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//不是周日的话，设置成周日，并且周+1
		if (dayOfWeek != 1) {
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			cal.add(Calendar.WEEK_OF_YEAR, 1);
		}
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int)(cal.getTime().getTime() / 1000);
	}
	/**
	 * 获取时间戳timeSecond的下一月的起始时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getNextMonthStartSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	/**
	 * 获取时间戳timeSecond的下一月的结束时间
	 * @author yang_huidi
	 * @param timeSecond
	 * @return  
	 */
	
	public static final int getNextMonthEndSecond(int timeSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date((timeSecond)*1000L));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return (int)(cal.getTime().getTime() / 1000);
	}
	
	
	/**
	 * main方法
	 */
	public static void main(String[] args) {
		int now = DateUtil.now()+86400*30;
		
		System.out.println("======================");
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentDayStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentDayEndSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentWeekStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentWeekEndSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentMonthStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getCurrentMonthEndSecond(now)));
		
		System.out.println("======================");
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextDayStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextDayEndSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextWeekStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextWeekEndSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextMonthStartSecond(now)));
		
		System.out.println(DateUtil.second2DateTimeStr(DateUtil.getNextMonthEndSecond(now)));
	}
}
