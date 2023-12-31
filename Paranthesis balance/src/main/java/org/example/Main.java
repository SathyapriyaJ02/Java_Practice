package org.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String input = "(())){}";

        char[] input_arr = input.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char c : input_arr)
        {
            if(c=='(' || c=='{' || c=='[')
            {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty())
                {
                    System.out.println("false");
                }
                else {
                    char pop = stack.pop();
                    System.out.println((pop));
                    if(!((pop=='(' && c==')')|| (pop=='{' && c=='}')|| (pop=='[' && c==']')))
                    {
                        System.out.println("false");
                    }
                    else
                    {
                        System.out.println("true");
                    }
                }
            }
        }


    }
}