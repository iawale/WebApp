/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.custommvc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chirag
 */
public class DbConnection {

    private Connection con = null;
    private PreparedStatement statement = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/coursemanager", "root", "");
    }

    public PreparedStatement initStatement(String sql) throws SQLException {
        statement = con.prepareStatement(sql);
        return statement;
    }

    public ResultSet executeQuery() throws SQLException {
        return statement.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        return statement.executeUpdate();
    }

    public void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
            con = null;
        }
    }
}
