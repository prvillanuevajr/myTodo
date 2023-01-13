package com.presmelito.mytodo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String toHuman(LocalDateTime localDateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/D/yy hh:mm:ss a");
        return localDateTime.format(dateTimeFormatter);
    }
}
