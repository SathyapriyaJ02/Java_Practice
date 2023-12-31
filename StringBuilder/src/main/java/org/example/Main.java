package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println(getCommonCharacters("java","javascript"));
        System.out.println(getCommonCharacters("apple","palace"));
        System.out.println(getCommonCharacters("hello world","world hello"));

    }

    public static String getCommonCharacters(String str1, String str2) {
        StringBuilder commonChar = new StringBuilder();
        StringBuilder remainingStr2 = new StringBuilder(str2);

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);

            int index = remainingStr2.indexOf(String.valueOf(c));
            if (index != -1) {
                // If the current character is present in remainingStr2
                commonChar.append(c);

                // Remove the matched character from remainingStr2
                remainingStr2.deleteCharAt(index);
            }
        }

        return commonChar.toString();
    }
}