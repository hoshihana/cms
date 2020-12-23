package team.cms.util;

import java.util.Date;

public class DateUtil {

    public static Date parseDateString(String date) {
        return new Date(Long.valueOf(date));
    }

    public static Date parseDatetimeString(String datetime) {
        return new Date(Long.valueOf(datetime));
    }
}
