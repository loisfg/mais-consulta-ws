package com.bandtec.mais.consulta.utils;

public class CalendarUtil {
    private static volatile CalendarUtil instance = new CalendarUtil();

    private CalendarUtil() {}

    private static CalendarUtil getInstance() {
        if (instance == null) {
            synchronized (CalendarUtil.class) {
                if (instance == null) {
                    instance = new CalendarUtil();
                }
            }
        }
        return instance;
    }

    public Object readResolve() {
        return getInstance();
    }


}