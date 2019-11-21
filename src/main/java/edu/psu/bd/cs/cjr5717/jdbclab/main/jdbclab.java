package edu.psu.bd.cs.cjr5717.jdbclab.main;

import java.sql.*;
import java.util.Scanner;

public class jdbclab {
    public static void main(String[] args) {

        try {

        Connection C = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\cjr5716\\IdeaProjects\\jdbclab\\src\\main\\resources\\mybookstore");

        System.out.print("Type the name of the book you are searching for: ");
//        Scanner S = new Scanner(System.in);
//        String query = S.nextLine();

        String query2 = "Sushi, Anyone?";

        String sql = "SELECT titles.title, authors.au_fname, authors.au_lname FROM authors INNER JOIN titles ON titles.au_id = authors.au_id WHERE titles.title LIKE ?";

        PreparedStatement P = C.prepareStatement(sql);
        P.setString(1, query2);

        ResultSet R = P.executeQuery();

            while (R.next()) {
                R.toString();
            }

        C.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}