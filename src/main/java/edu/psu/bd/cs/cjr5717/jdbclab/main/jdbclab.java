package edu.psu.bd.cs.cjr5717.jdbclab.main;

import java.sql.*;
import java.util.Scanner;

public class jdbclab {
    public static void main(String[] args) {

        try {

//        Connection C = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\cjr5716\\IdeaProjects\\jdbclab\\src\\main\\resources\\mybookstore");
        Connection C = DriverManager.getConnection("jdbc:sqlite:mybookstore");
            // Please use jdbc:sqlite:<path>

        System.out.print("Type the name of the book you are searching for: ");
        Scanner S = new Scanner(System.in);
        String query2 = S.nextLine();

//        String query2 = "Sushi, Anyone?";

        String sql  = "SELECT titles.title, authors.au_fname, authors.au_lname FROM authors INNER JOIN titles ON titles.au_id = authors.au_id WHERE titles.title LIKE ?";
        String sql2 = "SELECT pub_name FROM publishers INNER JOIN titles ON titles.pub_id = publishers.pub_id WHERE titles.title LIKE ?";


        PreparedStatement P = C.prepareStatement(sql);
         P.setString(1, query2);


        PreparedStatement P1 = C.prepareStatement(sql2);
        P1.setString(1, query2);

        ResultSet R  = P.executeQuery();
        ResultSet R2 = P1.executeQuery();

        if (!R.isClosed()) {

            System.out.println("Title: " + R.getString("title"));
            System.out.print("Author: " + R.getString("au_fname"));
            System.out.print(" " + R.getString("au_lname") + '\n');
            System.out.println("Publisher: " + R2.getString("pub_name"));

        C.close();

        }else {
            System.out.println("The value \"" + query2 + "\" could not be found in the table");
        }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
