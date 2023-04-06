package br.com.java.spring.data.jpa.academia.config.utils;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    private static final Locale LOCALE_BR = new Locale("pt", "BR");
    public static final DateTimeFormatter FORMATADOR_DATA_HORA_LOCAL = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm:ss", LOCALE_BR
    );
    public static final DateTimeFormatter FORMATADOR_DATA_LOCAL = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy", LOCALE_BR
    );

    public DateTimeUtils() {
    }
}
