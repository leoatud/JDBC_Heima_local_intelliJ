package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CURD {

    public static void main(String[] args) throws Exception{
            delete();
            create();
            update();
            read();

    }

    /**
     * create
     */
    static void create() throws Exception{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBC_Util.getConnection();
            st = conn.createStatement();
            String sql = "insert into user(id,name,brithday,money) value (4,'leo','1991-12-05',0)";
            int i = st.executeUpdate(sql);
            System.out.println("i= "+i + " create successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,st, conn);
        }
    }






    /**
     * read
     */
    static void read() throws Exception{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBC_Util.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id,name,brithday,money from user");
            while(rs.next()){
                System.out.println(rs.getObject("id") + "\t"+
                        rs.getObject("name")+"\t"
                        +rs.getObject("brithday")+"\t"
                        +rs.getObject("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,st, conn);
        }
    }


    /**
     *update
     */
    static void update() throws Exception{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBC_Util.getConnection();
            st = conn.createStatement();
            String sql = "update user set money = money+10";
            int i = st.executeUpdate(sql);
            System.out.println("i= "+i + " update successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,st, conn);
        }
    }


    /**
     *delete
     */
    static void delete() throws Exception{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBC_Util.getConnection();
            st = conn.createStatement();
            String sql = "delete from user where money > 300";
            int i = st.executeUpdate(sql);
            System.out.println("i= "+i + " delete successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,st, conn);
        }
    }

}
