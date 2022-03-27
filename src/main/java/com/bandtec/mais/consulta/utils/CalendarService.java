package com.bandtec.mais.consulta.utils;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CalendarService {
    private static final Map<Integer, Map<Integer, Map<String, Integer>>> hashCalendarDays = new HashMap<>();
    private static CalendarService instance;
    private final Map<String, Map<String, Integer>> hashMonthDataUtil = new HashMap<>();
    private final ArrayList<HolidayVO> holidayList = new ArrayList<>();
    private final HashMap<Integer, Integer> holidayIndex = new HashMap<>();

    public static CalendarService getInstance() {
        if (instance == null) instance = new CalendarService();
        return instance;
    }

    private CalendarService() {
    }

    private final SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    private static class HolidayVO {
        Integer dtReference;
        Integer count;
    }

    public Integer getIntDate(Calendar calendar, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return Integer.parseInt(sf.format(calendar.getTime()));
    }

    public String IntToString(Integer date) {
        String completeDate = date.toString();
        String year = completeDate.substring(0, 4);
        String month = completeDate.substring(4, 6);
        String day = completeDate.substring(6, 8);
        return year + "-" + month + "-" + day;
    }

    public String getFormattedDate(Integer date) {
        String year = date.toString().substring(0, 4);
        String month = date.toString().substring(4, 6);
        String day = date.toString().substring(6, 8);
        return day + "/" + month + "/" + year;
    }

    public Integer getLastDayMonth(Integer yyyyMM) throws NumberFormatException, ParseException {
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

        endCalendar.setTime(format.parse(yyyyMM.toString()));

        Integer lastDayMonth = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return Integer.parseInt(String.valueOf(yyyyMM) + lastDayMonth);
    }

    private int getTotalHolidays(Integer startDate, Integer endDate) {
        int index = holidayIndex.get(startDate);
        int totalHolidays = 0;
        for (; index < holidayList.size(); index++) {
            if (holidayList.get(index).dtReference <= endDate) {
                totalHolidays += holidayList.get(index).count;
            } else {
                break;
            }
        }
        return totalHolidays;
    }

    public Integer getCalendarDays(Integer initialDate, Integer endDate, String format) throws ParseException {
        if (!hashCalendarDays.containsKey(initialDate)) {
            hashCalendarDays.put(initialDate, new HashMap<>());
        }
        Map<Integer, Map<String, Integer>> hashCalendarDaysByOneDate = hashCalendarDays.get(initialDate);
        if (!hashCalendarDaysByOneDate.containsKey(endDate)) {
            hashCalendarDaysByOneDate.put(endDate, new HashMap<>());
        }
        Map<String, Integer> hashDateFormats = hashCalendarDaysByOneDate.get(endDate);
        if (hashDateFormats.containsKey(format)) {
            return hashDateFormats.get(format);
        }
        Calendar initC = Calendar.getInstance();
        Calendar endC = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        initC.setTime(sdf.parse(String.valueOf(initialDate)));
        endC.setTime(sdf.parse(String.valueOf(endDate)));
        Integer calendarDays = getCalendarDays(initC, endC);
        hashDateFormats.put(format, calendarDays);
        return calendarDays;
    }

    public int getCalendarDays(Calendar initC, Calendar endC) {
        long init = initC.getTimeInMillis();
        long end = endC.getTimeInMillis();
        int initDST = initC.get(Calendar.DST_OFFSET);
        int endDST = endC.get(Calendar.DST_OFFSET);
        long numberHours = (end - init);
        if (endDST > initDST) {
            numberHours = numberHours + endDST;
        } else if (initDST > endDST) {
            numberHours = numberHours - initDST;
        }
        numberHours = numberHours / 1000 / 3600;
        return (int) numberHours / 24;
    }

    public Calendar getDate(LocalDate date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar dtDate = Calendar.getInstance();
        dtDate.setTime(format.parse(date.toString()));
        return dtDate;
    }

    @SneakyThrows
    public Date getIntToDate(Integer date) {
        SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
        return formatYYYYMMDD.parse(date.toString());
    }

    @SneakyThrows
    public List<String> arrayDate(String initDate, String endDate) {
        List<String> list = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = df.parse(initDate);
        Date dt2 = df.parse(endDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt1);
        for (Date date = dt1; date.compareTo(dt2) <= 0; ) {
            calendar.add(Calendar.DATE, +1);
            date = calendar.getTime();

            list.add(df.format(date));
        }

        return list;
    }
}