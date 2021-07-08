package Others.Udemy.String;

/*
You are building a logic for a clock that requires you convert absolute time in minutes into a format supported by a digital clock. See examples below.
125 minutes can be displayed as 2:05
155 minutes can be displayed as 2:35
(You can assume the maximum value of minutes will be less than 24 X 60)
Input is a single integer.
1180
Output:
19:40
Output is a string denoting the digital clock time.
 */
public class DigitalClock {

    public static String getDigitalTime(int absTime) {
        int hours = absTime / 60;
        int minutes = absTime % 60;
        return hours + ":" + minutes;
    }

    public static void main(String[] args) {
        System.out.println(getDigitalTime(1180));
    }
}