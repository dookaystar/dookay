package dookay.dklibrary.settings;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期 和小数 优化
 * Created by "Qaufue" on 2017/11/16.
 */

public class DateDecimalUtils {

    // 保留两位小数
    public static String getString(double db) {
        return String.format("%.2f", db);
    }

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat format0 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    static SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日");
    static SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
    static SimpleDateFormat format3 = new SimpleDateFormat("E");
    static SimpleDateFormat format4 = new SimpleDateFormat("yyyy.MM.dd");

    static SimpleDateFormat format5 = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    public static String getTimeYear(long time) {
        return milliseconds2String(time, format);
    }

    public static String getTimeYearOne(long time) {
        return milliseconds2String(time, format0);
    }

    public static String getTimeYearTwo(long time) {
        return milliseconds2String(time, format1);
    }

    public static String getTimeYearThree(long time) {
        return milliseconds2String(time, format2);
    }

    public static String getTimeYearFor(long time) {
        return milliseconds2String(time, format3);
    }

    public static String getTimeYearFive(long time) {
        return milliseconds2String(time, format4);
    }

    public static String getTimeYearSix(long time) {
        return milliseconds2String(time, format5);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为用户自定义</p>
     *
     * @param milliseconds 毫秒时间戳
     * @param format       时间格式
     * @return 时间字符串
     */
    public static String milliseconds2String(long milliseconds, SimpleDateFormat format) {
        return format.format(new Date(milliseconds));
    }

}
