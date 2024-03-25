package com.library.mgmnt.books;

import com.library.mgmnt.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReturnBook {
    public static boolean returnBook() throws SQLException {
        Scanner bookReturn = new Scanner(System.in);

        System.out.println("Enter Return Date:");
        String returnDate = bookReturn.nextLine();


        System.out.println("Enter Member Id:");
        int memberId = bookReturn.nextInt();

        System.out.println("Enter Book Id:");
        int bookId = bookReturn.nextInt();

        Connection con = null;
        try {
            con = DataBaseUtil.getConnection();

            Statement stmt = con.createStatement();
            String query = "insert into issue_return values(" + bookId + "," + memberId + "," + null + ",'" + returnDate + "')";
            int statement = stmt.executeUpdate(query);
            if (statement != 0) {
                System.out.println("Return Date succesfully added");
            } else {
                System.out.println("Return Date was not added");
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

