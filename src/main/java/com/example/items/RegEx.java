package com.example.items;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private boolean isStringValid(String str) {
        Pattern p = Pattern.compile("^([A-Z][a-z]{2,15})$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    private boolean isEMailValid(String str) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
