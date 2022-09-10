package com.interviewdeck.utils;

public class Utils {
    public static boolean isBlank(String str) {
        if(str==null) return true;
        str = str.trim();
        return str.isEmpty();
    }
}
