package com.java.problems.code360.easy;

public class StringReformat {
    public static void main(String[] args) {
        stringReformat("Ab-ijklmno-pqr", 3);
        stringReformat("Isa-dkj", 4);

    }
    public static String stringReformat(String s, int k) {
        s = s.replace("-", "");
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        while (s.length() > 0) {
            int len = s.length()%k > 0 ? s.length()%k: k;
            String str = s.substring(0, len);
            s = s.substring(len);
            sb.append(str);
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();

    }
}
