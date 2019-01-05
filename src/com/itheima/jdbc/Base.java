package com.itheima.jdbc;

import java.sql.*;

public class Base {
    public static void main(String[] args) {

        try {
            template();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static void template() throws Exception{

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        //String query = "select * from user";

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection(url,user,password)；
            conn = JDBC_Util.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from user");
            while(rs.next()){
                System.out.println(rs.getObject(1) + "\t"+
                                rs.getObject(2)+"\t"
                                +rs.getObject(3)+"\t"
                                +rs.getObject(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,st, conn);
        }

    }







    static void test() throws SQLException {
        //1.register with driver, use static
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
//


        //using reflection

        try {
            Class.forName("com.jdbc.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.setup connection: through driver managaer
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc","root","Achen888?");

        //3.create statement
        Statement st = connection.createStatement();

        //4.execute the statement
        ResultSet rs = st.executeQuery("select * from user");

        //5.deal with result
        while(rs.next()){
            System.out.println(rs.getObject(1) + "\t" );
//                                rs.getObject(2)+"\t"
//                                +rs.getObject(3)+"\t"
//                                +rs.getObject(1));
        }

        System.out.println("execute all statement");
        //6.releaese resource
        rs.close();
        st.close();
        connection.close();

    }
}
