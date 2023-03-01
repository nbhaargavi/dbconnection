package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class Creation
{
    String dname;
    String uname;
    String pw;
    Connection conn;
    static Creation frst=null;
    Logger l=Logger.getLogger("tyler");
    private Creation(String dname, String uname, String pw)
    {
        this.dname = dname;
        this.uname = uname;
        this.pw = pw;
    }
    public static Creation in(String dname, String uname, String pw)
    {
        if(frst==null)
        {
            frst=new  Creation(dname, uname, pw);
        }
        return frst;
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

