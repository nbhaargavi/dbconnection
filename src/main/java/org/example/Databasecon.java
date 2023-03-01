package org.example;
import java.util.Scanner;
import java.util.logging.Logger;

public class Databasecon {
    public static void main(String[] args) {
        String dname;
        String uname;
        String pw;
        Scanner s = new Scanner(System.in);
        Logger l = Logger.getLogger("kitty");
        l.info("Enter the database name:");
        dname = s.next();
        l.info("Enter your username:");
        uname = s.next();
        l.info("Enter your password:");
        pw = s.next();
        Creation c1 = Creation.in(dname, uname, pw);
        c1.connect();
        c1.cl();
    }
}

