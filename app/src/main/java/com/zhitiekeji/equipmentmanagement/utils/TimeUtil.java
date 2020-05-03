package com.zhitiekeji.equipmentmanagement.utils;

import java.util.Calendar;

/**
 * Created by zyz on 2017/8/17.
 */

public class TimeUtil {
    /**
     * 获取当前年份
     * @return
     */
    public static int GetYear() {
        Calendar c = Calendar.getInstance();//首先要获取日历对象
        return c.get(Calendar.YEAR); // 获取当前年份

    }

}
