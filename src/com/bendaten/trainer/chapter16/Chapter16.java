package com.bendaten.trainer.chapter16;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class Chapter16 {
    protected static Logger logger = Logger.getLogger(Chapter16.class.getName());

    static final String URL = "jdbc:mysql://localhost:3306/telusko";
    static final String USER_NAME = "root";
    static final String PASSWORD = "Zse";

    /*
     * 1. import
     * 2. load driver
     * 3. register the driver
     * 4. create connection
     * 5. create a query
     * 6. execute the query
     * 7. process the results
     * 8. close
     *
     * +-------+-------------+------+-----+---------+----------------+
     * | Field | Type        | Null | Key | Default | Extra          |
     * +-------+-------------+------+-----+---------+----------------+
     * | id    | int         | NO   | PRI | NULL    | auto_increment |
     * | name  | varchar(40) | NO   |     | NULL    |                |
     * +-------+-------------+------+-----+---------+----------------+
     */

    public static void work() {
        logger.log(Level.INFO, "In Chapter 16");

        Properties info = new Properties();
        info.put("user", USER_NAME);
        info.put("password", PASSWORD);

        String query;
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement()){

            query = "INSERT INTO students (name) VALUES ('Daniel')";
            int rows = st.executeUpdate(query);
            query = "INSERT INTO students (name) VALUES ('Haim')";
            rows = st.executeUpdate(query);
            query = "INSERT INTO students (name) VALUES ('Moshe')";
            rows = st.executeUpdate(query);
            query = "INSERT INTO students (name) VALUES ('Yossi')";
            rows = st.executeUpdate(query);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "select * FROM students WHERE id = 2";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)){
            rs.next();
            String name = rs.getString("name");
            System.out.println(name);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "SELECT * FROM students";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)){
            while (rs.next()) {
                String data = String.format("%d : %s", rs.getInt("id"), rs.getString("name"));
                System.out.println(data);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "INSERT INTO students (name) VALUES ('Aliza')";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement()){

            int rows = st.executeUpdate(query);
            System.out.println(String.format("inserted %d rows", rows));

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "SELECT * FROM students";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)){
            while (rs.next()) {
                String data = String.format("%d : %s", rs.getInt("id"), rs.getString("name"));
                System.out.println(data);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (Connection con = getConnection(URL, info);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, 17);
            pst.setString(2, "Sasha");
            int rows = pst.executeUpdate();
            System.out.println(String.format("inserted %d rows", rows));

            pst.setInt(1, 117);
            pst.setString(2, "Abedalla");
            rows = pst.executeUpdate();
            System.out.println(String.format("inserted %d rows", rows));
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "SELECT * FROM students";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)){
            while (rs.next()) {
                String data = String.format("%d : %s", rs.getInt("id"), rs.getString("name"));
                System.out.println(data);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        query = "TRUNCATE TABLE students";
        try (Connection con = getConnection(URL, info);
             Statement st = con.createStatement()){

            int rows = st.executeUpdate(query);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot use mysql", e);
        }

        // execute only static block in a class
        try {
            Class.forName("com.bendaten.trainer.chapter16.LoadExample");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "cannot forName()", e);
        }

        // DAO
        StudentDAO sdao = new StudentDAO("telusko", "students");
        sdao.addStudent(new Student(1, "Daniel"));
        sdao.addStudent(new Student(1, "Yossi"));
        sdao.addStudent(new Student(1, "Haim"));
        sdao.addStudent(new Student(1, "Itzik"));
        sdao.addStudent(new Student(1, "Giora"));
        System.out.println(sdao.getStudent(1).getName());
        System.out.println(sdao.getStudent(4).getName());
        sdao.truncateStudents();
    }
}
