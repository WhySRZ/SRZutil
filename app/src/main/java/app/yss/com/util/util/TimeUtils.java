package app.yss.com.util.util;

/**
 *  项目描述:
 *  作者: shenrunzhou 
 *  创建时间  :2019-01-23  10:35
 */

public class TimeUtils {
    private static long mFirstClickTime = 0L;

    //设置双击退出应用
    public static boolean checkDoubleClick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mFirstClickTime > 1000) {
            mFirstClickTime = currentTime;
            return false;
        } else {
            return true;
        }
    }
}
