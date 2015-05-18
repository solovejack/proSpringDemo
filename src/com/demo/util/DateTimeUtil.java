package com.demo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 日期时间工具类
 * @author 100494
 */
public final class DateTimeUtil {  
    /** 格式(yyyy) */
    public static final String FORMAT_YYYY = "yyyy";
    /** 格式(MM) */
    public static final String FORMAT_MM = "MM"; 
    /** 格式(dd) */
    public static final String FORMAT_DD = "dd"; 
    /** 格式(yyyy-MM) */
    public static final String FORMAT_YYYY_MM = "yyyy-MM";
    /** 格式(MM-dd) */
    public static final String FORMAT_MM_DD = "MM-dd";
    /** 格式(yyyy-MM-dd) */
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    /** 格式(yyyy-MM-dd HH:mm) */
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /** 格式(yyyy-MM-dd HH:mm:ss) */
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /** 格式(yyyy-MM-dd HH:mm:ss SSS) */
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss SSS";
    /** 格式(HH:mm:ss) */
    public static final String FORMAT_HH_MM_SS = "HH:mm:ss";
    /** 格式(HH:mm) */
    public static final String FORMAT_HH_MM = "HH:mm";
    /** 格式(HH:mm:ss SSS) */
    public static final String FORMAT_HH_MM_SS_SSS = "HH:mm:ss SSS";
	/** 格式(yyyy年MM月dd日) */
	public static final String FORMAT_YYYY_MM_DD_CN = "yyyy年MM月dd日";
	
	/** 0点整 */
	public static final String ZERO_CLOCK = "00:00";
	/** 8点整 */
	public static final String EIGHT_CLOCK = "08:00";
	/** 16点整 */
	public static final String SIXTEEN_CLOCK = "16:00";
	/** 24点整 */
	public static final String TWENTYFOUR_CLOCK = "24:00";
	
    /**
     * 构造方法
     */
    private DateTimeUtil() {
		super();
	}

	/**
	 * 得到指定格式的日期
	 * @param date 日期
	 * @param format 格式
	 * @return 指定格式的日期
	 */
	public static String getDate(Date date, String format) {
		if (AssertUtil.isInval(date)) {
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		simpleDateFormat.setLenient(false);
		return simpleDateFormat.format(date);
	}

    /**
     * 得到当前系统日期
     * @return 当前系统日期
     */
    public static String getCurrentDate() {
    	return getDate(new Date(), FORMAT_YYYY_MM_DD);
    }

    /**
     * 得到当前系统时间
     * @return 当前系统时间
     */
    public static String getCurrenTime() {
    	return getDate(new Date(), FORMAT_HH_MM_SS);
    }

    /**
     * 得到当前系统日期时间
     * @return 当前系统日期时间
     */
    public static String getCurrentDateTime() {
    	return getDate(new Date(), FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 得到当前系统日期时间
     * @return 当前系统日期时间
     */
    public static String getCurrentDateTimeMill() {
    	return getDate(new Date(), FORMAT_YYYY_MM_DD_HH_MM_SS_SSS);
    }

    /**
     * 取得当前的年份
     * @return 年份字符串
     */
    public static String getCurrentYear() {
    	return getDate(new Date(), FORMAT_YYYY);
    }

    /**
     * 取得当前的月份
     * @return 月份字符串
     */
    public static String getCurrentMonth() {
    	return getDate(new Date(), FORMAT_MM);
    }

    /**
     * 取得当前的年月
     * @return 年月字符串
     */
    public static String getCurrentYearMonth() {
    	return getDate(new Date(), FORMAT_YYYY_MM);
    }
    
    /**
     * 取得当前年份的最后一位
     * @return 当前年份的最后一位
     */
    public static String getCurrentYearMantissa() {
        return getCurrentYear().substring(3);
    }
    
    /**
     * 得到当前年份号
     * @return 当前年份号
     */
    public static int getCurrentYearForInt() {
        Calendar theDay = Calendar.getInstance();
        return theDay.get(Calendar.YEAR);
    }
   	
	/**
	 * 得到当前的XMLGregorianCalendar时间
	 * @return 当前的XMLGregorianCalendar时间
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getCurrentXMLGregorianCalendar() throws DatatypeConfigurationException {
		return parseDateToXMLGregorianCalendar(new Date());
	}

	/**
	 * 根据Date时间得到XMLGregorianCalendar时间
	 * @param date Date时间
	 * @return XMLGregorianCalendar时间
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar parseDateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	}
	
	/**
	 * 根据XMLGregorianCalendar时间得到Date时间字符串
	 * @param cal XMLGregorianCalendar时间
	 * @return Date时间字符串
	 * @throws Exception
	 */
	public static String getDate(XMLGregorianCalendar cal) throws Exception{
		if (AssertUtil.isInval(cal)) {
			return "";
		}
        GregorianCalendar ca = cal.toGregorianCalendar();
        return getDate(ca.getTime(), FORMAT_YYYY_MM_DD_HH_MM_SS);
    }
	
	/**
     * 转换时间戳为系统规定格式时间
     * @param timeStamp 时间戳
     * @return 系统规定格式时间
     */
    public static String transTimeStamp(Timestamp timeStamp) {
    	String dateTime = "";
    	if (AssertUtil.isVal(timeStamp)) {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS_SSS);
        	dateTime = simpleDateFormat.format(timeStamp);  
    	}
    	return dateTime;
    }
    
	/**
	 * 得到同一天内的两个时间点之间的分钟数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return int 分钟数
	 * @throws ParseException 异常
	 */
	public static int getTimeLength(String startTime, String endTime) throws ParseException {
		if (startTime.compareTo(endTime) > 0) {
			String timeTemp = startTime;
			startTime = endTime;
			endTime = timeTemp;
		}
		long timeLength = 0;
		SimpleDateFormat dfs = new SimpleDateFormat(FORMAT_HH_MM);
		Date begin = dfs.parse(startTime);
		Date end = dfs.parse(endTime); 
		timeLength = (end.getTime() - begin.getTime()) / 1000 / 60;
		return (int)timeLength;
	}

	/**
	 * 得到两个日期时间点之间的分钟数
	 * @param startDateTime 开始日期时间
	 * @param endDateTime 结束日期时间
	 * @return int 分钟数
	 * @throws ParseException 异常
	 */
	public static int getDateTimeLength(String startDateTime, String endDateTime) throws ParseException {
		if (startDateTime.compareTo(endDateTime) > 0) {
			String timeTemp = startDateTime;
			startDateTime = endDateTime;
			endDateTime = timeTemp;
		}
		long timeLength = 0;
		SimpleDateFormat dfs = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM);
		Date begin = dfs.parse(startDateTime);
		Date end = dfs.parse(endDateTime); 
		timeLength = (end.getTime() - begin.getTime()) / 1000 / 60;
		return (int)timeLength;
	}
	
	/**
	 * 得到两个日期之间（包含端点）的天数
	 * @param startDate 开始日期
	 * @param endDate 开始日期
	 * @return int 天数
	 * @throws ParseException  异常
	 */
	public static int getDateLength(String startDate, String endDate) throws ParseException {
		if (startDate.compareTo(endDate) > 0) {
			String timeTemp = startDate;
			startDate = endDate;
			endDate = timeTemp;
		}
		long dateLength = 0;
		SimpleDateFormat dfs = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		Date begin = dfs.parse(startDate);
		Date end = dfs.parse(endDate);
		dateLength = (end.getTime() - begin.getTime()) / 1000 / 60 / 60 / 24;
		return ((int) dateLength) + 1;
	}
    
    /**
     * 指定年份加num年后的年份
     * @param year 指定年份
     * @param num 多少年
     * @return 年份
     */
    public static String addYear(String year, int num) {
    	return String.valueOf(Integer.valueOf(year) + num);
    }
    
    /**
     * 指定年月加num年后的年月
     * @param yearMonth 指定年月
     * @param num
     * @return 年月
     * @throws ParseException 
     */
    public static String addYearMonth(String yearMonth, int num) throws ParseException {
    	SimpleDateFormat dfs = new SimpleDateFormat(FORMAT_YYYY_MM);
		Date yearMonthTemp = dfs.parse(yearMonth);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(yearMonthTemp);
		gc.add(Calendar.MONTH, num);
		yearMonthTemp = gc.getTime();
		return getDate(yearMonthTemp, FORMAT_YYYY_MM);
    }
    
    /**
     * 指定月份加num年后的月份
     * @param month 指定月份
     * @param num
     * @return 月份
     * @throws Exception 
     */
    public static String addMonth(String month, int num) throws Exception {
    	if (month.compareTo("01") < 0 || month.compareTo("12") > 0) {
    		throw new Exception("月份值不正确！");
    	}
    	int monthTemp = Integer.valueOf(month);
    	if (num % 12 <= 0) {
    		monthTemp = monthTemp + num % 12;
    		if (monthTemp <= 0) {
    			monthTemp = monthTemp + 12;
    		}
    	} else {
    		monthTemp = (monthTemp + num) % 12;
    	}
    	
    	if (monthTemp == 0) {
    		monthTemp = 12;
    	}
    	
    	return String.valueOf(monthTemp);
    }
	
	/**
	 * 根据字符串时间得到指定格式的Date日期
	 * @param date 日期
	 * @param format 格式
	 * @return Date 日期
	 * @throws ParseException
	 */
	public static Date getDate(String date, String format) throws ParseException {
		SimpleDateFormat dfs = new SimpleDateFormat(format);
		Date day = dfs.parse(date);
		return day;
	}
	
	/**
	 * 取得时间点所在的上班开始和结束时间
	 * @param classTime 时间点
	 * @return 上班开始和结束时间
	 */
	public static String findClassTimeScope(String classTime) {
		String classTimeScope = "";
		if (ZERO_CLOCK.compareTo(classTime) <= 0 && classTime.compareTo(EIGHT_CLOCK) <= 0) {
			classTimeScope = ZERO_CLOCK + "_" + EIGHT_CLOCK;
		} else if (EIGHT_CLOCK.compareTo(classTime) <= 0 && classTime.compareTo(SIXTEEN_CLOCK) <= 0) {
			classTimeScope = EIGHT_CLOCK + "_" + SIXTEEN_CLOCK;
		} else if (SIXTEEN_CLOCK.compareTo(classTime) <= 0 && classTime.compareTo(TWENTYFOUR_CLOCK) <= 0) {
			classTimeScope = SIXTEEN_CLOCK + "_" + TWENTYFOUR_CLOCK;
		}
		return classTimeScope;
	}
	
	/**
	 * 取得日期的中文表示
	 * @param date 日期
	 * @return 日期的中文表示
	 */
	public static String getDateCHN(String date) {
		return date.substring(0, 4) + "年" + date.substring(5, 7) + "月" + date.substring(8, 10) + "日";
	}
	public static String getDateMMDD(String date) {
            return date.substring(5, 7) + "-" + date.substring(8, 10) ;
      }

    public static String getDateTime(long dateLong) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
		Date date = new Date(dateLong);  
		return sdf.format(date);
    }
    
    public static long getDateTime(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
		return sdf.parse(dateStr).getTime();
    }
}
