package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by linwu on 1/2/2018.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(null == is){
                throw new FileNotFoundException(fileName + " file not found");
            }
            props = new Properties();
            props.load(is);
        }catch (IOException e){
            LOGGER.error("load Properties file failure", e);
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return Optional.ofNullable(props).orElse(new Properties());
    }

    /**
     *获取字符型属性（默认值为“ ”）
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key){
        return getString(props, key, StringUtils.EMPTY);
    }

    /**
     * 获取字符型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue){
        String value = defaultValue;
        if (props.containsKey(key)){
            return props.getProperty(key);
        }
        return value;
    }

}
