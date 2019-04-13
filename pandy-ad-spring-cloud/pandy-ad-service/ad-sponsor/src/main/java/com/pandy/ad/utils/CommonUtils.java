package com.pandy.ad.utils;


import com.pandy.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:32
 * @Version 1.0
 */
public class CommonUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd","yyyy/MM/dd","yyyy.MM.dd"
    };

    /**
     * token以md5方式加密
     * @param value
     * @return
     */
    public static String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    /**
     * 将String类型的日期转化成正确的格式
     * @param dateString
     * @return
     * @throws AdException
     */
    public static Date parseStringDate(String dateString)
            throws AdException{
        try {
            return DateUtils.parseDate(
                    dateString
                    ,parsePatterns
            );
        }catch (Exception e){
            throw new AdException(e.getMessage());
        }
    }
}
