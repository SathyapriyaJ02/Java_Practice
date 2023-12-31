package org.example;
class Question
{
    private int questionNo;
    private String question;
    private String options [];
    private int correctAns;
    private int score=0;

    Question(int questionNo,String question,String options [],int correctAns)
    {
        this.questionNo= questionNo;
        this.question = question;
        this.options = options;
        this.correctAns = correctAns;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setQno(int questionNo)
    {
        this.questionNo= questionNo;
    }
    public int getQno()
    {
        return questionNo;
    }
    public void setQ(String question)
    {
        this.question= question;
    }
    public String getQ()
    {
        return question;
    }
    public void setOptions(String options[])
    {
        this.options = options;
    }
    public String[] getOptions()
    {
        return options;
    }

    public boolean answerCheck(int selectedAns)
    {
        if(correctAns == selectedAns)
        {
            return true;

        }
        else
        {
            return false;
        }
    }


}
