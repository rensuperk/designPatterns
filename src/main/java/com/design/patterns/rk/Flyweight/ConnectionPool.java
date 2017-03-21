package com.design.patterns.rk.Flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by renkai on 2017/3/21.
 */
public class ConnectionPool {
    private Vector<Connection> pool;
    /*公有属性*/
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";

    private int poolSize = 100;
    private static ConnectionPool instance = null;
    Connection conn = null;
    private ConnectionPool(){
        pool = new Vector<Connection>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(url,username,password);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void release(){
        pool.add(conn);
    }
    public synchronized Connection getConn(){
        if(pool.size()>0){
            conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }else {
            return null;
        }
    }
}
