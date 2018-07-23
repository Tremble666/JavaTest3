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
    //根据Country ID。返回所有属于这个Country的CityID及名称
    public static void QueryCity(int countryid) throws Exception{
        Connection conn = DruidUtils.getConn();
        String sql = "select city_id,city from city where country_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,countryid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int city_id = rs.getInt("city_id");
            String city = rs.getString("city");
            //System.out.println("country_id="+countryid+"==>"+"   city_id="+city_id+",cityname="+city);
            System.out.println("Country ID:"+countryid);
            System.out.println("City ID | City Name");
            System.out.println(city_id+" | "+city);
        }
        System.out.println("first success");
        DruidUtils.close(conn,ps,rs);
    }
    //根据Customer ID。返回这个Customer中租的所的Film，按租用时间倒排序
    public static void QueryFilm(int customer_id) throws Exception{
        Connection conn = DruidUtils.getConn();
        String sql = "select t1.film_id,t3.rental_date,t2.first_name from (inventory t1 join customer t2 on t1.store_id = t1.store_id) join rental t3 on t2.customer_id = t3.customer_id where t2.customer_id = ? order by rental_date desc";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,customer_id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int film_id = rs.getInt("film_id");
            String name = rs.getString("first_name");
            Object date = rs.getObject("rental_date");
            //System.out.println("customer = "+customer_id+"==>film_id="+film_id+",date="+date.toString());
            System.out.println("Customer ID:"+customer_id);
            System.out.println("'"+name+"'"+"film");
            System.out.println("FILM Id "+"| Film Name |"+"Time");
            System.out.println(film_id+" | name | "+date.toString());
        }
        System.out.println("second success");
        DruidUtils.close(conn,ps,rs);
    }
    @Test
    public void testQureyCountry() throws Exception{
        QueryCity(2);
        QueryFilm(2);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("First question:");
        QueryCity(2);
        System.out.println("==========================");
        System.out.println("Second question:");
        QueryFilm(2);
    }
}
