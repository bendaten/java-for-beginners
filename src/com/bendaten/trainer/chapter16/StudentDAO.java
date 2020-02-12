package com.bendaten.trainer.chapter16;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class StudentDAO {
    protected static Logger logger = Logger.getLogger(StudentDAO.class.getName());
    private String url;
    private String table;
    Properties info;

    private static final String BASE_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Zse";

    public StudentDAO(String database, String table) {
        this.url = String.format("%s%s", BASE_URL, database);
        this.table = table;
        info = new Properties();
        info.put("user", USER_NAME);
        info.put("password", PASSWORD);
    }

    public Student getStudent(int id) {
        String query = String.format("SELECT name FROM %s WHERE id = %d", table, id);

        try (Connection con = getConnection(url, info);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)){
            rs.next();
            String name = rs.getString("name");
            return new Student(id, name);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        return null;
    }

    public boolean addStudent(Student student) {
        String query = String.format("INSERT INTO %s (name) VALUES ('%s')", table, student.getName());
        try (Connection con = getConnection(url, info);
             Statement st = con.createStatement()){
            return st.executeUpdate(query) > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }
        return false;
    }

    public void truncateStudents() {
        String query = String.format("TRUNCATE TABLE %s", table);
        try (Connection con = getConnection(url, info);
             Statement st = con.createStatement()){

            st.executeUpdate(query);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }
    }
}
