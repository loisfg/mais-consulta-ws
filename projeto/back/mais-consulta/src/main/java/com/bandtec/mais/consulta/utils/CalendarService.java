package com.bandtec.mais.consulta.utils;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CalendarService {
    private final static Logger log = LoggerFactory.getLogger(CalendarService.class);
    private static final Map<Integer, Map<Integer, Map<String, Integer>>> hashDiasCorridos = new HashMap<>();
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
        String mounth = completeDate.substring(4, 6);
        String day = completeDate.substring(6, 8);
        return year + "-" + mounth + "-" + day;
    }

    public String getFormatedDate(Integer date) {
        String year = date.toString().substring(0, 4);
        String month = date.toString().substring(4, 6);
        String day = date.toString().substring(6, 8);
        return day + "/" + month + "/" + year;
    }

    public Integer getUltimaDataDoMes(Integer yyyyMM) throws NumberFormatException, ParseException {
        Calendar calenFim = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMM");

        calenFim.setTime(formato.parse(yyyyMM.toString()));

        Integer ultimoDiaMes = calenFim.getActualMaximum(Calendar.DAY_OF_MONTH);

        return Integer.parseInt(String.valueOf(yyyyMM) + ultimoDiaMes);
    }

    private int getTotalFeriados(Integer dtStart, Integer dtFim) {
        int index = holidayIndex.get(dtStart);
        int totalFeriados = 0;
        for (; index < holidayList.size(); index++) {
            if (holidayList.get(index).dtReference <= dtFim) {
                totalFeriados += holidayList.get(index).count;
            } else {
                break;
            }
        }
        return totalFeriados;
    }

    public Integer getDiasCorridos(Integer initialDate, Integer endDate, String format) throws ParseException {
        if (!hashDiasCorridos.containsKey(initialDate)) {
            hashDiasCorridos.put(initialDate, new HashMap<>());
        }
        Map<Integer, Map<String, Integer>> hashDiasCorridosDeUmaData = hashDiasCorridos.get(initialDate);
        if (!hashDiasCorridosDeUmaData.containsKey(endDate)) {
            hashDiasCorridosDeUmaData.put(endDate, new HashMap<>());
        }
        Map<String, Integer> hashFormatosData = hashDiasCorridosDeUmaData.get(endDate);
        if (hashFormatosData.containsKey(format)) {
            return hashFormatosData.get(format);
        }
        Calendar cIni = Calendar.getInstance();
        Calendar cFim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        cIni.setTime(sdf.parse(String.valueOf(initialDate)));
        cFim.setTime(sdf.parse(String.valueOf(endDate)));
        Integer diasCorridos = getDiasCorridos(cIni, cFim);
        hashFormatosData.put(format, diasCorridos);
        return diasCorridos;
    }

    public int getDiasCorridos(Calendar cIni, Calendar cFim) {
        long ini = cIni.getTimeInMillis();
        long fim = cFim.getTimeInMillis();
        int iniDST = cIni.get(Calendar.DST_OFFSET);
        int fimDST = cFim.get(Calendar.DST_OFFSET);
        long nroHoras = (fim - ini);
        if (fimDST > iniDST) { // Era horário normal e virou horario de verão
            nroHoras = nroHoras + fimDST;
        } else if (iniDST > fimDST) {
            nroHoras = nroHoras - iniDST;
        }
        nroHoras = nroHoras / 1000 / 3600;
        return (int) nroHoras / 24;
    }

    public Calendar getDate(LocalDate date) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        Calendar dtDate = Calendar.getInstance();
        dtDate.setTime(formato.parse(date.toString()));
        return dtDate;
    }

    @SneakyThrows
    public Date getIntToDate(Integer date) {
        SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
        return formatYYYYMMDD.parse(date.toString());
    }

    @SneakyThrows
    public List<String> arrayDate(String dtIni, String dtEnd) {
        List<String> list = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = df.parse(dtIni);
        Date dt2 = df.parse(dtEnd);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt1);
        for (Date dt = dt1; dt.compareTo(dt2) <= 0; ) {
            cal.add(Calendar.DATE, +1);
            dt = cal.getTime();

            list.add(df.format(dt));
        }

        return list;
    }
}