package com.library.mgmnt;

import com.library.mgmnt.books.*;
import com.library.mgmnt.constants.LibraryConstants;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryManagementProgram {

    public static void main(String[] args) throws SQLException {

        boolean result = true;
        Scanner obj = new Scanner(System.in);

        while (result) {
            System.out.println("Enter input as 'ADD BOOK' for adding a book to library");
            System.out.println("Enter input as 'ADD MEMBER' for adding a member to library");
            System.out.println("Enter input as 'ISSUE BOOK' for issuing a book");
            System.out.println("Enter input as 'RETURN BOOK' for returning a book to library");
            System.out.println("Enter input as 'EXIT' to stop the program");
            String userInput = obj.nextLine();
            result = processUserInput(userInput);
        }
    }

    public static boolean processUserInput(String value) throws SQLException {
        switch (value) {
            case LibraryConstants.ADD_BOOK:
                return AddBookDetails.addBook();
            case LibraryConstants.ADD_MEMBER:
                return AddMemberDetails.addMember();
            case LibraryConstants.ISSUE_BOOK:
                return IssueBook.issueBook();
            case LibraryConstants.RETURN_BOOK:
                return ReturnBook.returnBook();
            case LibraryConstants.VALIDATE:
                return CheckBookReturn.verify();
            default:
                return false;
        }
    }
}