package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by linwu on 12/27/2017.
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否为非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


    public static String[] spliteString(String str, String spliteStr){
        if(isNotEmpty(str)){
            return StringUtils.split(str, spliteStr);
        }
        return null;
    }


}
