package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLongestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Should output "fl"
        System.out.println(findLongestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // Should output ""
        System.out.println(findLongestCommonPrefix(new String[]{"apple", "app", "application"})); // Should output "app"
    }

    public static String findLongestCommonPrefix(String[] words) {

        String prefix = words[0];
            for (int i = 0; i < prefix.length(); i++)
            {
                char currentChar = prefix.charAt(i);
                for (int j = 1; j < words.length; j++)
                {
                    if (i >= words[j].length() || words[j].charAt(i) != currentChar)
                    {
                        return prefix.substring(0, i);
                    }
                }
            }
            return prefix;



    }
}