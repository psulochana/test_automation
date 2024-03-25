package com.library.mgmnt.books;

import com.library.mgmnt.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddMemberDetails {
    public static boolean addMember() throws SQLException {
        Scanner memberDetails = new Scanner(System.in);

        System.out.println("Enter Member Name:");
        String memberName = memberDetails.nextLine();

        System.out.println("Enter Date Of Joining:");
        String dateOfJoining = memberDetails.nextLine();

        System.out.println("Enter Member Id:");
        int memberId = memberDetails.nextInt();

        Connection con = null;
        try {
            con = DataBaseUtil.getConnection();

            Statement stmt = con.createStatement();
            String query = "insert into member values(" + memberId + ",'" + memberName + "','" + dateOfJoining + "')";
            int statement = stmt.executeUpdate(query);
            if (statement != 0) {
                System.out.println("Member succesfully added");
            } else {
                System.out.println("Member was not added");
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
