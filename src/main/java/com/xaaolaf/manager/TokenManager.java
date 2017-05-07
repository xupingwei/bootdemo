package com.xaaolaf.manager;

import com.xaaolaf.common.MD5Util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by xupingwei on 2017/5/7.
 */
public class TokenManager {
    public static String createSign(Map<String, String> params, boolean encode) {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            try {
                if (encode) {
                    temp.append(URLEncoder.encode(valueString, "UTF-8"));
                } else {
                    temp.append(valueString);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                temp.append(valueString);
            }
        }

        return MD5Util.md5Hex(temp.toString()).toUpperCase();
    }
}

