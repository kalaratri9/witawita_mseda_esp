package com.company.transfer.utilities.functions;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class FormatUtils.
 */
public class FormatUtils {

	/** The Constant SLASH_DDMMYYYY_DATE_FORMAT. */
	public static final SimpleDateFormat SLASH_DDMMYYYY_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	/** The Constant YYMMDD_HHMMSS_DATE_FORMAT. */
	public static final SimpleDateFormat YYMMDD_HHMMSS_DATE_FORMAT = new SimpleDateFormat("YY/MM/dd HH:mm:ss");

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Instantiates a new format utils.
	 */
	public FormatUtils() {
		super();
	}

	/**
	 * Clear time to date.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date clearTimeToDate(Date date) {
		if (date != null) {
			try {
				return SLASH_DDMMYYYY_DATE_FORMAT.parse(SLASH_DDMMYYYY_DATE_FORMAT.format(date));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return null;
	}
	
	/**
	 * Format 1.  
	 * 
	 * Format YY/MM/dd HH:mm:ss
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String format1(Date date) {
		if (date != null) {
			try {
				return YYMMDD_HHMMSS_DATE_FORMAT.format(date);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return null;
	}
	
	
	/**
	 * Hash.
	 *
	 * @return the string
	 */
	public static String hash() {
		String strTime = String.valueOf(new Date().getTime());
		Integer hash = 0;
		for (int i = 0; i < strTime.length(); i++) {
			hash = strTime.charAt(i) + ((hash << 5) - hash);
		}
		String result = Integer.toString(hash);
		return result.substring(result.length() -2);
	}

}
