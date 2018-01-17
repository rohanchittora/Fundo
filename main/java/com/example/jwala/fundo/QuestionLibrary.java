package com.example.jwala.fundo;

public class QuestionLibrary{

    private static String[] mQuestions={
         "Which part of the plant holds it in the soil?",
            "This part of the plant absorbs energy from the sun.",
            "This part of the plant attracts bees.",
            "The __________ holds the plant upright."
    };

    private String mChoices[][]={
            {"Roots", "Stems", "Flowers"},
            {"Fruits", "Leaves", "Seeds"},
            {"Bark","Flower","Roots"},
            {"Flower","Leaves","Stem"}
    };

    private String mCorrectAnswers[]={"Roots","Leaves","Flower","Stem"};

    public String getQuestion(int a){
        String question=mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice1=mChoices[a][0];
        return choice1;
    }

    public String getChoice2(int a){
        String choice2=mChoices[a][1];
        return choice2;
    }

    public String getChoice3(int a){
        String choice3=mChoices[a][2];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String correctAnswer=mCorrectAnswers[a];
        return correctAnswer;
    }

    public static int max(){
        return mQuestions.length;
    }

}