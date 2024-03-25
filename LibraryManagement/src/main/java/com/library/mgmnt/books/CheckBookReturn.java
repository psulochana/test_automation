package com.library.mgmnt.books;

import com.library.mgmnt.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckBookReturn {
    public static boolean verify() throws SQLException {
        Scanner bookIssue = new Scanner(System.in);

        System.out.println("Enter Member Id :");
        String memberId = bookIssue.nextLine();

        Connection con = null;
        try {
            con = DataBaseUtil.getConnection();

            Statement stmt = con.createStatement();
            String query = "select * from issue_return where member_id=" + memberId;
            ResultSet result = stmt.executeQuery(query);

            String issueDt = null;
            String returnDt = null;
            while (result.next()) {
                if (result.getString("issue_date") != null) {
                    issueDt = result.getString("issue_date");
                }

                if (result.getString("return_date") != null) {
                    returnDt = result.getString("return_date");
                }
            }

            if (issueDt != null && returnDt != null) {
                System.out.println("Returned Book SUCCESS");
            } else {
                System.out.println("Not Returned yet");
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
