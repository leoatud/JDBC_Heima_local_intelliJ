package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInject {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        read("zhangsan");
        long end = System.currentTimeMillis();
        System.out.println("start time: "+ start + "n/" + "end time: "+end);
        System.out.println(end-start);
    }



    /**
     * read
     */
    static void read(String name) throws Exception{
        Connection conn = null;
        //Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = JDBC_Util.getConnection();
            String query = "select id,name,brithday,money from user where name =?";
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            //rs = ps.executeQuery("select id,name,brithday,money from user where name ='" + name + "'");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getObject("id") + "\t"+
                        rs.getObject("name")+"\t"
                        +rs.getObject("brithday")+"\t"
                        +rs.getObject("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBC_Util.free(rs,ps, conn);
        }
    }

}
