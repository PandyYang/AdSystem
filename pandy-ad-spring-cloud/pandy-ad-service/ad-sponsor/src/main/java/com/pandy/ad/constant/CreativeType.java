package com.pandy.ad.constant;

import lombok.Getter;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:40
 * @Version 1.0
 */
@Getter
public enum CreativeType {

    IMAGE(1,"图片"),
    VIDEO(2,"视频"),
    TEXT(3,"文本类型");

    private int type;
    private String desc;

    CreativeType(int type,String desc){
        this.type = type;
        this.desc = desc;
    }
}
