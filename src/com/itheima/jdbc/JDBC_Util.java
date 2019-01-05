package com.itheima.jdbc;

import java.sql.*;

public class JDBC_Util {
    static String url = "jdbc:mysql://localhost:3306/jdbc";
    static String user = "root";
    static String password = "Achen888?";

    private JDBC_Util(){

    }


    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{

            return DriverManager.getConnection(url,user,password);

    }


    public static void free(ResultSet rs, Statement st, Connection conn){

        if(rs!=null)

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(st!=null)

            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(conn!=null)

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


//    private static JDBC_Util instance = null;
//    public static JDBC_Util getInstance(){
//        if(instance == null){
//
//            synchronized (JDBC_Util.class) {
//                if(instance==null)
//                    instance = new JDBC_Util();
//            }
//        }
//        return instance;
//    }

}
