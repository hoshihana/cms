package team.cms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    final static String DATE_FORMAT = "yyyy-MM-dd";

    final static String DATETIME_FORMAT = "yyyy-MM-dd HH-mm-ss";

    public static Date parseDateString(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date parseDatetimeString(String datetime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            return sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
