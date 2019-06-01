package com.erikriosetiawan.quiz;

public class QuestionLibrary {

    private String[] mQuestions = new String[]{
            "Jaringan komputer yang cakupannya lokal yaitu ... ",
            "Pendiri Microsoft adalah ... ",
            "Ibu Kota Indonesia yaitu ... ",
            "Ketuhanan Yang Maha Esa adalah sila ke ... ",
            "Indonesia berada di benua ... "
    };

    private String[][] mChooices = new String[][]{
            {"LAN", "MAN", "WAN"},
            {"Bill Gates", "Larry Page", "Steve Jobs"},
            {"Bandung", "Jakarta", "Surabaya"},
            {"Sila ke-4", "Sila ke-5", "Sila ke-1"},
            {"Amerika", "Eropa", "Asia"}
    };

    private String[] mCorrectAnswers = new String[]{"LAN", "Bill Gates", "Jakarta", "Sila ke-1", "Asia"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoiceOne(int a) {
        String choiceZero = mChooices[a][0];
        return choiceZero;
    }

    public String getChoiceTwo(int a) {
        String choiceOne = mChooices[a][1];
        return choiceOne;
    }

    public String getChoiceThree(int a) {
        String choiceTwo = mChooices[a][2];
        return choiceTwo;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getLength() {
        return mQuestions.length;
    }

}
