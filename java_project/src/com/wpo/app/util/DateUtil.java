package com.wpo.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date parse tools
 * <p>
 * Title: DateUtil.java
 * </p>
 * 
 * Description:
 * <p>
 * 
 * <pre>
 * A Date tools parse String to Date or generate a String delegate the input Date
 * </pre>
 * 
 * @author walker
 */
public class DateUtil {

	public final static String YYYY = "yyyy";
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	public final static String YYYYMMDD = "yyyyMMdd";
	public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public final static String YYYYMMDDHHMM = "yyyyMMddHHmm";
	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * generate a date object uses the given string and format
	 * 
	 * @param str
	 *            - the source string use the parameter format to express
	 * @param format
	 *            - the String in this class such as
	 *            <code>DateUtil.YYYYMMDD</code>
	 * @return
	 */
	public static Date getFormatDate(String str, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(str);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * generate a String uses the given Date and format
	 * 
	 * @param date
	 *            - the source date will format
	 * @param format
	 *            - the String in this class such as
	 *            <code>DateUtil.YYYYMMDD</code>
	 * @return
	 */
	public static String getDateString(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * generate a String uses the given Date
	 * 
	 * @param date
	 *            - the source date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (index < 0)
			index = 0;
		return weekDays[index];
	}

}
