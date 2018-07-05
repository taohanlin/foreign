package com.foreign.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间辅助类
 * @author taohanlin
 * @date 2018年6月21日 下午5:18:31
 */
public class DateUtil {

	public final static ThreadLocal<SimpleDateFormat> ymdNoDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHmNoDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyMMddHHmm");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> yymdHmNoDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmm");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHmsDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHmsSDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> hmsDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm:ss");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdUnderLine = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy_MM_dd");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHmsNoDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdHmsSNoDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmssSSS");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> ymdSlash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy/MM/dd");
		}
	};

	public final static ThreadLocal<SimpleDateFormat> msSDash = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("mmssSSS");
		}
	};

	public static String toString(Calendar cal, SimpleDateFormat dateFormat) {
		return dateFormat.format(cal.getTime());
	}

	public static String toString(Date date, SimpleDateFormat dateFormat) {
		return dateFormat.format(date);
	}

	public static int toDayInt(Calendar cal) {
		return cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH) + 1) * 100 + cal.get(Calendar.DAY_OF_MONTH);
	}

	public static int toDayInt(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return toDayInt(cal);
	}

	public static Long toHourLong(Calendar cal) {
		return (long) toDayInt(cal) * 100 + cal.get(Calendar.HOUR_OF_DAY);
	}

	public static Long toHourLong(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return toHourLong(cal);
	}

	public static Long toMinuteLong(Calendar cal) {
		return toHourLong(cal) * 100 + cal.get(Calendar.MINUTE);
	}

	public static Long toMinuteLong(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return toMinuteLong(cal);
	}

	public static int toWeekInt(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static int toWeekInt(String day) {
		Date date = toDate(day, ymdNoDash.get());
		return toWeekInt(date);
	}

	public static Date toDate(String dateStr, SimpleDateFormat dateFormat) {
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static int getDayOffset(Date start, Date end) {
		long hour24InMillis = 24 * 60 * 60 * 1000;
		long startMillis = DateUtil.toDate("1971-01-01", ymdDash.get()).getTime();
		return (int) ((end.getTime() - startMillis) / hour24InMillis - (start.getTime() - startMillis) / hour24InMillis);
	}

	public static Date addTimes(Date date, int type, int amount) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(type, amount);
		return c.getTime();
	}

	public static int getProperty(Date date, int property) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(property);
	}
}
