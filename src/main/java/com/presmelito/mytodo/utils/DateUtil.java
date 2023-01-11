package com.presmelito.mytodo.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String toHuman(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");
        return localDateTime.format(dateTimeFormatter);
    }
}
