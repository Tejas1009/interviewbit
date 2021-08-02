package Others.ULA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeNotification {
    private static final long ONE_MINUTE = 60000L;
    private static final String ONE_SECOND_AGO = "second ago";
    private static final String ONE_MINUTE_AGO = "minute ago";
    private static final String SECONDS_AGO = "seconds ago";
    private static final String MINUTES_AGO = "minutes ago";
    private static final String ONE_HOUR_AGO = "hour ago";
    private static final String HOURS_AGO = "hours ago";

    public static void main(String[] args) throws ParseException {
        String P[] = {"23:05:38"};
        String res[] = solve("23:04:31", 1, P);
        for (String s : res) {
            System.out.println(s);
        }
    }

/*    static String[] solve(String R, int N, String[] P) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:m:s");
        Date givenDate = format.parse(R);
        String[] res = new String[N];
        for (int i = 0; i < P.length; i++) {
            Date compareToDate = format.parse(P[i]);
            res[i] = format(givenDate, compareToDate);
        }
        return res;
    }*/

    static String[] solve(String R, int N, String[] P) {
        String[] res = new String[N];
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:m:s");
            Date givenDate = format.parse(R);
            for (int i = 0; i < P.length; i++) {
                Date compareToDate = format.parse(P[i]);
                res[i] = format(givenDate, compareToDate);
            }
        } catch (Exception e) {

        }
        return res;
    }

    public static String format(Date givenDate, Date compareToDate) {
        long delta = compareToDate.getTime() - givenDate.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = Math.abs(toSeconds(delta));
            if (seconds == 0) {
                return "now";
            }
            if (seconds == 1) return seconds + " " + ONE_SECOND_AGO;
            return seconds + " " + SECONDS_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            if (minutes == 1) return minutes + " " + ONE_MINUTE_AGO;
            return minutes + " " + MINUTES_AGO;
        } else {
            long hours = toHours(delta);
            if (hours == 1) return hours + " " + ONE_HOUR_AGO;
            return hours + " " + HOURS_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

}
