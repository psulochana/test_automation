package com.library.mgmnt.books;

import com.library.mgmnt.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBookDetails {

    public static boolean addBook() throws SQLException {

        Scanner obj = new Scanner(System.in);

        System.out.println("Enter Book Name:");
        String bookName = obj.nextLine();

        System.out.println("Enter Book Id:");
        int bookId = obj.nextInt();

        System.out.println("Enter Author:");
        String author = obj.nextLine();

        System.out.println("Enter Book Description:");
        String bookDescription = obj.nextLine();

        System.out.println("Enter Genre:");
        String genre = obj.nextLine();

        System.out.println("Enter Published Year:");
        int publishedYear = obj.nextInt();

        System.out.println("Enter Units Available:");
        int unitsAvailable = obj.nextInt();

        Connection con = null;
        try {
            con = DataBaseUtil.getConnection();

            Statement stmt = con.createStatement();
            String query = "insert into book values('" + bookName + "'," + bookId + ",'" + author + "','" + bookDescription + "','" + genre + "'," + publishedYear + "," + unitsAvailable + ")";
            int statement = stmt.executeUpdate(query);
            if (statement != 0) {
                System.out.println("Book succesfully added");
            } else {
                System.out.println("Book was not added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return true;
    }
}
