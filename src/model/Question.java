package model;

public class Question {
    private int questionId;
    private String question;
    private String optionA, optionB, optionC, optionD;
    private String correctOption;

    public Question() { }

    public Question(int questionId, String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionId = questionId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public int getQuestionId() { return questionId; }
    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectOption() { return correctOption; }
}
