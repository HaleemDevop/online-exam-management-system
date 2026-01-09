package model;

public class Result {
    private int resultId;
    private String username;
    private int score;
    private int totalQuestions;

    public Result() { }

    public Result(int resultId, String username, int score, int totalQuestions) {
        this.resultId = resultId;
        this.username = username;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    public int getResultId() { return resultId; }
    public String getUsername() { return username; }
    public int getScore() { return score; }
    public int getTotalQuestions() { return totalQuestions; }
}
