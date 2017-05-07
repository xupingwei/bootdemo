package com.xaaolaf.common;

import java.util.Collection;

/**
 * Created by xupingwei on 2017/5/7.
 */
public class ColletionUtils {

    public static boolean isNotEmpty(Collection collection) {
        return (null != collection && !collection.isEmpty());
    }

    public static boolean isEmpty(Collection coll) {
        return !isNotEmpty(coll);
    }
}
