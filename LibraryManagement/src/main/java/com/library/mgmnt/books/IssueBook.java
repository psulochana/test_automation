package com.library.mgmnt.books;

import com.library.mgmnt.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IssueBook {
    public static boolean issueBook() throws SQLException {
        Scanner bookIssue = new Scanner(System.in);

        System.out.println("Enter Issue Date:");
        String issueDate = bookIssue.nextLine();


        System.out.println("Enter Member Id:");
        int memberId = bookIssue.nextInt();

        System.out.println("Enter Book Id:");
        int bookId = bookIssue.nextInt();

        Connection con = null;
        try {
            con = DataBaseUtil.getConnection();

            Statement stmt = con.createStatement();
            String query = "insert into issue_return values(" + bookId + "," + memberId + ",'" + issueDate + "'," + null + ")";
            int statement = stmt.executeUpdate(query);
            if (statement != 0) {
                System.out.println("Issue Date succesfully added");
            } else {
                System.out.println("Issue Date was not added");
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