package com.online.restaurant.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class OrderDAO {
    public static final String TABLE_NAME = "app_order";

    public void createTable() {
        try {
            //1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");
            //2.
            Connection con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1003");
            // 3.
            Statement stmt = con.createStatement();
            //4.
            String sql = " Select * from " + TABLE_NAME;
            String query = " CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + "( id bigint NOT NULL, "
                    + " vendor_id bigint ,"
                    + " customer_id bigint ,"
                    + " total_amount decimal ,"
                    + " delivery_address text,"
                    + " status text ,"
                    + " order_date timestamp,"
                    + " category text,"
                    + " CONSTRAINT app_order_pk PRIMARY KEY (id))";

            System.out.println(" Create Table Query : " + query);
            stmt.executeUpdate(query);

            ResultSet rs = stmt.executeQuery(sql);
            //5.
            while (rs.next()) {
                System.out.println(" Name = " + rs.getString("name"));
                System.out.println("Address = " + rs.getString("address"));
                System.out.println(" City= " + rs.getString("city"));
                System.out.println(" State = " + rs.getString("state"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}