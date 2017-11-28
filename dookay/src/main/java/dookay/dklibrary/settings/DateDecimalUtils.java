package dookay.dklibrary.settings;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * 日期 和小数 优化
 * Created by "Qaufue" on 2017/11/16.
 */

public class DateDecimalUtils {

    // 保留两位小数
    public String getString(double db) {
        return String.format("%.2f", db);
    }

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
    SimpleDateFormat format3 = new SimpleDateFormat("E");






}
