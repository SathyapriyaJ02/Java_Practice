package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        for(int i=0;i<=n;i++)
////        {
////            String str = sc.nextLine();
////            String[] strSplit = str.split("[^a-zA-Z0-9]");
////            if(strSplit[0].equals(strSplit[strSplit.length-1]))
////            {
////                System.out.println("yes");
////            }
////        }
//        String sentence = "I love to code";
//        String[] words = sentence.split("\\s");
//        StringBuilder rearrangedSentence = new StringBuilder();
//
//        for (int i = 1; i < words.length; i++) {
//            if (words[i].length() < words[i - 1].length()) {
//                rearrangedSentence.append(words[i]).append(" ");
//            } else {
//                rearrangedSentence.append(words[i - 1]).append(" ");
//            }
//        }
//
//        // Append the last word (no need for comparison)
//        rearrangedSentence.append(words[words.length - 1]);
////        System.out.println(Arrays.toString(str));
//        System.out.println(rearrangedSentence);
//    }
public static void main(String[] args) {
    String sentence = "i love to code";
    String[] words = sentence.split("\\s");
    StringBuilder newWord = new StringBuilder();
    Arrays.sort(words, Comparator.comparing(String::length));
    for(String word : words)
    {
        newWord.append(word+" ");
    }
    newWord.setCharAt(0, Character.toUpperCase(newWord.charAt(0)));
    newWord.setLength(newWord.length() - 1);
    newWord.append(".");
    System.out.println(newWord);

}


}
