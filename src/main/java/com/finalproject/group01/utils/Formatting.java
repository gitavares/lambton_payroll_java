package com.finalproject.group01.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatting {

    Locale locale = new Locale("en", "CA");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    public Formatting() {
    }

    public String getCurrencyFormatter(Double value) {
        return currencyFormatter.format(value);
    }

    public String getPercentageFormatter(Double value) {
        return value + "%";
    }
}
