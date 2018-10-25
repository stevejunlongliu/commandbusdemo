package com.liujl.core.boot;

import java.util.Comparator;

/**
 * Created by liujl on 2018/8/2.
 */
public class ClassNameComparator implements Comparator<Class<?>> {
    @Override
    public int compare(Class<?> o1, Class<?> o2) {
        if (o1 == null)
            return -1;
        if (o2 == null)
            return 1;
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
