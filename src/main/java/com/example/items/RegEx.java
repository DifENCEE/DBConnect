package com.example.items;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private boolean isStringValid(String str) {
        Pattern p = Pattern.compile("^[a-z0-9\\[\\]A-Z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
    private boolean isEMailValid(String str) {
        Pattern p = Pattern.compile("^[a-z0-9\\[\\]A-Z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
