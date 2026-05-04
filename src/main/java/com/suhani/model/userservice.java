package com.suhani.model;

import com.suhani.config.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userservice {

    public boolean registerUser(String firstName, String lastName,
                                String email, String username, String password) {
        boolean status = false;
        String sql = "INSERT INTO users (first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean checkLogin(String email, String password) {
        boolean status = false;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}