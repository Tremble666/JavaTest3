package com.hand;

import org.junit.Test;

import javax.annotation.processing.SupportedSourceVersion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by chenjin on 2018/7/23.
 */
public class test1 {
    public static final int COUNTRYID;
    public static final int CUSTOMERID;

    static{
        COUNTRYID = Integer.parseInt(System.getenv("country-id"));
        CUSTOMERID = Integer.parseInt(System.getenv("customer-id"));
    }
    //根据Country ID。返回所有属于这个Country的CityID及名称
    public static void QueryCity() throws Exception{
        Connection conn = DruidUtils.getConn();
        System.out.println("connection success!");
        String sql = "select city_id,city from city where country_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,COUNTRYID);
        ResultSet rs = ps.executeQuery();
        System.out.println("City ID | City Name");
        while (rs.next()){
            int city_id = rs.getInt("city_id");
            String city = rs.getString("city");

            System.out.println(city_id+" | "+city);
        }
        System.out.println("first success");
        DruidUtils.close(conn,ps,rs);
    }


    //根据Customer ID。返回这个Customer中租的所的Film，按租用时间倒排序
    public static void QueryFilm() throws Exception{
        Connection conn = DruidUtils.getConn();
        String sql = "select f.*, r.rental_date from film f, rental r, inventory i where r.customer_id = ? and r.inventory_id = i.inventory_id and i.film_id = f.film_id order by r.rental_date DESC";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,CUSTOMERID);
        ResultSet rs = ps.executeQuery();
        System.out.println("FILM Id "+"| Film Name |"+"Time");
        while (rs.next()){
            int film_id = rs.getInt("film_id");
            String name = rs.getString("title");
            Object date = rs.getObject("rental_date");
            System.out.println(film_id+" | "+name+" | "+date.toString());
        }
        System.out.println("second success");
        DruidUtils.close(conn,ps,rs);
    }
    @Test
    public void testQureyCountry() throws Exception{
        QueryCity();
        QueryFilm();
    }
    public static void main(String[] args) throws Exception {
        System.out.println("First question:");
        QueryCity();
        System.out.println("==========================");
        System.out.println("Second question:");
        QueryFilm();
    }
}
