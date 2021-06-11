package io.github.mateusmsc.maxsorriso.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testes {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("((^| )[A-Za-z])");
        Matcher m = p.matcher("Mateus Santos Costa");
        String initials = "";
        while (m.find()) {
            initials += m.group().trim();
        }
        System.out.println(initials.toUpperCase());
    }
}
