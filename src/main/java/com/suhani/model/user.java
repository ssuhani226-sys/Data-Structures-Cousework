package com.suhani.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userservice {

    public boolean checkLogin(String email, String password) {

        boolean status = false;

        try {
            Connection conn = database.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}