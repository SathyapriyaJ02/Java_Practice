package org.example;

import java.util.*;
class MainClass {

    public static int evaluate(Question qArray[]) {
        int score = 0;
        for(Question Q : qArray) {
            score+=Q.getScore();
        }
        return score;

    }

    public static void main(String a[]) {
        Question q[] = new Question[10];
        q[0] = new Question(1, " Which of the following option leads to the portability and security of Java?", new String[]{"1.Bytecode is executed by JVM", "2.The applet makes the Java code secure and portable", "3.Use of exception handling", "4.Dynamic binding between objects\n"}, 1);

        q[1] = new Question(2, " Which of the following is not a Java features?", new String[]{"1.Dynamic",
                "2.Architecture Neutral",
                "3.Use of pointers",
                "4.Object-oriented\n"}, 3);

        q[2] = new Question(3, " The \u0021 article referred to as a", new String[]{"1.Unicode escape sequence",
                "2.Octal escape",
                "3.Hexadecimal",
                "4.Line feed\n"}, 1);

        q[3] = new Question(4, "____ is used to find and fix bugs in the Java programs.", new String[]{"1.JVM", "2.JRE", "3.JDK", "4.JDB\n"}, 4);

        q[4] = new Question(5, "Which of the following for loop declaration is not valid?", new String[]{"1.for ( int i = 99; i >= 0; i / 9 )",
                "2.for ( int i = 7; i <= 77; i += 7 )",
                "3.for ( int i = 20; i >= 2; - -i )",
                "4.for ( int i = 2; i <= 20; i = 2* i )\n"}, 1);

        q[5] = new Question(6, "What is the return type of the hashCode() method in the Object class?", new String[]{"1.Object", "2.int", "3.long",
                "4.void\n"}, 2);

        q[6] = new Question(7, "Which of the following is a valid long literal?", new String[]{"1.ABH8097", "2.L990023", "3.904423", "4.0xnf029L\n"}, 4);

        q[7] = new Question(8, "What does the expression float a = 35 / 0 return?", new String[]{"1.0", "2.Not a Number", "3.Infinity", "4.Run time exception\n"}, 3);

        q[8] = new Question(9, "Evaluate the following Java expression, if x=3, y=5, and z=10: ++z + y - y + z + x++", new String[]{"1.24", "2.23", "3.20", "4.25"}, 4);

        q[9] = new Question(10, "Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?", new String[]{"1.javap tool", "2.javaw command", "3.Javadoc tool",
                "4.javah command"}, 3);

        System.out.println("------------------Welcome-----------------------");
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] userAnswers = new int[q.length]; // to store user's answers

        while (i < q.length) {
            System.out.println("Q" + q[i].getQno() + ")" + q[i].getQ());
            for (String option : q[i].getOptions()) {
                System.out.println(option);
            }

            int ans;
            boolean condition = false;

            do {
                System.out.println("Enter your choice : ");
                ans = sc.nextInt();
                condition = (ans < 1 || ans > q[i].getOptions().length);

                if (condition) {
                    System.out.println("Invalid option, Try again!");
                } else {
                    userAnswers[i] = ans; // store user's answer

                    int opt;

                    if (i == 0 && i == q.length - 1) {
                        System.out.println("Invalid option, Try again!");
                        condition = true;
                    } else if (i == 0) {
                        System.out.println("6 for next question");
                        opt = sc.nextInt();
                        if (opt == 6) {
                            i++;
                        } else {
                            System.out.println("Invalid option, Try again!");
                            condition = true;
                        }
                    } else if (i == q.length - 1) {
                        System.out.println("5 for prev question");
                        opt = sc.nextInt();
                        if (opt == 5) {
                            i--;
                        } else {
                            System.out.println("Invalid option, Try again!");
                            condition = true;
                        }
                    } else {
                        System.out.println("5 for prev question\t6 for next question");
                        opt = sc.nextInt();
                        if (opt == 5) {
                            i--;
                        } else if (opt == 6) {
                            i++;
                        } else {
                            System.out.println("Invalid option, Try again!");
                            condition = true;
                        }
                    }
                }
            } while (condition);
        }

        for (i = 0; i < q.length; i++) {
            q[i].answerCheck(userAnswers[i]); // check and set scores
        }

        System.out.println("Your Score is: " + evaluate(q) + "/" + q.length);
    }
}
