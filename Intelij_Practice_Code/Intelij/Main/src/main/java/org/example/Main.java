package org.example;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email address :\n");
        String e = sc.nextLine();

        if(validateEmail(e))      //calls validateEmail Method.
        {
            System.out.println("Email ID is valid.");
        }
        else
        {
            System.out.println("Email ID is invalid.");
        }

    }

    static boolean validateEmail(String e)     //method is static so no need to create obj.
    {
       int indexOfAt = e.indexOf('@');    //stores index of @
       int indexOfDot = e.lastIndexOf('.');   // stores index of last occurance of '.' as it may be a tld part.
       String username = e.substring(0,indexOfAt);  // as username part is present before @
       String domainAndTLD = e.substring(indexOfAt+1); // as domain and tld part is present after @


       if(indexOfAt<=0 || indexOfDot<=indexOfAt || indexOfDot == e.length()-1)  //checks the postion of @ and .
       {
           return false;
       }
       if(!Character.isLowerCase(username.charAt(0)))
       {
           return false;
       }

       for(int i=0;i<username.length();i++)   //checks the given conditions for valid username part of email Id.
       {
           char ch = username.charAt(i);
           if(!Character.isLetterOrDigit(ch) && ch!='_' && ch!='.' && i != indexOfAt-1)
           {
               return false;
           }
       }
           if(domainAndTLD.indexOf('.') == -1)     //checks the index of dot, that it should not present in last index.
           {
               return false;
           }
           String domain = domainAndTLD.substring(0,domainAndTLD.indexOf('.')); //dividing domain and tld part.
           String tld = domainAndTLD.substring(domainAndTLD.indexOf('.')+1); //tld is present after dot index.

           if(!Character.isLowerCase(domain.charAt(0)))  //checks the case of domain part.
           {
               return false;
           }
           if(tld.length()<2 || tld.length() >6) //checks the length of tld.
           {
               return false;
           }

           for(char c : tld.toCharArray())    //checks the case of tld.
           {
                if(!Character.isLowerCase(c))
               {
                   return false;
               }
           }
           return true;
    }
}