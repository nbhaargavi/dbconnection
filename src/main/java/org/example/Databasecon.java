package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Databasecon
{

    public static void main(String[] args)
    {
        String dname;
        String uname;
        String pw;
        Scanner s =new Scanner(System.in);
        Logger l=Logger.getLogger("kitty");
        l.info("Enter the database name:");
        dname=s.next();
        l.info("Enter your username:");
        uname=s.next();
        l.info("Enter your password:");
        pw=s.next();
        Creation c1= Creation.in(dname,uname,pw);
        c1.connect();
        c1.cl();
    }
    public static class Creation
    {
        String dname;
        String uname;
        String pw;
        Connection conn;
        Logger l=Logger.getLogger("tyler");
        private Creation(String dname, String uname, String pw)
        {
            this.dname = dname;
            this.uname = uname;
            this.pw = pw;
        }
        public static Creation in(String dname, String uname, String pw)
        {
            return new Creation(dname, uname, pw);
        }
        void connect()
        {
            try {
                conn = DriverManager.getConnection(dname, uname, pw);
                l.info("Connection established successfully ");
            } catch (Exception e) {
                l.log(Level.INFO,() -> String.valueOf(e));
            }
        }
        void cl()
        {
            try {
                conn.close();
                l.info("Closed");
            }
            catch(Exception e)
            {
                l.log(Level.INFO,() -> String.valueOf(e));
            }
        }
    }
}