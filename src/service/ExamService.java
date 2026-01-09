package service;

import model.Question;
import model.Result;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamService {

    // Get all questions from DB
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("question_id"),
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correct_option")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // Add question (Admin)
    public void addQuestion(String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        String sql = "INSERT INTO questions (question, optionA, optionB, optionC, optionD, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, question);
            ps.setString(2, optionA);
            ps.setString(3, optionB);
            ps.setString(4, optionC);
            ps.setString(5, optionD);
            ps.setString(6, correctOption);
            ps.executeUpdate();
            System.out.println("Question added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Save exam result
    public void saveResult(String username, int score, int totalQuestions) {
        String sql = "INSERT INTO results (username, score, total_questions) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setInt(2, score);
            ps.setInt(3, totalQuestions);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
