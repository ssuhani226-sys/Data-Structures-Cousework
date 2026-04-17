package com.suhani.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.suhani.config.database;

public class userservice {

    public boolean checkLogin(String email, String password) {
        boolean found = false;

        try {
            Connection conn = database.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                found = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }
}