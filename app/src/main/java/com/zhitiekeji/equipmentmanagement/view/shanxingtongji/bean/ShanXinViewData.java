package com.zhitiekeji.equipmentmanagement.view.shanxingtongji.bean;

/**
 * Created by jiyang on 16-12-25.
 * 扇形图数据
 */

public class ShanXinViewData {
    public String name; //名字
    public int value;   //数值
    public int r;   //半径

    public int color;   //颜色
    public float percentage; //百分比
    public float angle; //角度

    public ShanXinViewData(int value, String name,int r) {
        this.value = value;
        this.name = name;
        this.r = r;
    }
}
