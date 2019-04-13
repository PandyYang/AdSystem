package com.pandy.ad.constant;

import lombok.Getter;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:44
 * @Version 1.0
 */
@Getter
public enum  CreativeMetrialType {
    JPG(1,"jpg"),
    BMP(2,"bmp"),

    MP4(3,"mp4"),
    AVI(4,"avi"),

    TXT(5,"txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type,String desc){
        this.type = type;
        this.desc = desc;
    }
}
