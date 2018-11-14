package com.brain.earthcitizenclub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateUtil extends DateUtils {

	public static Date convertStringToDate(String pattern, String strDate) {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(pattern);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new RuntimeException(pe.getMessage(), pe);
        }

        return date;
    }
}
