package com.hand;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by chenjin on 2018/7/22.
 */
//一个工具类
public class DruidUtils {
    private static Properties pro = new Properties();
    private static DruidDataSource ds = null;

    private DruidUtils() {
    };

    static {
        ds = new DruidDataSource();
        String ip = System.getenv("IP");
        String port=System.getenv("PORT");
        String dbname=System.getenv("DBNAME");
        String username = System.getenv("USERNAME");
        String password=System.getenv("PASSWORD");
        ds.setUrl("jdbc:mysql://"+ip+":"+port+"/"+dbname);
        ds.setUsername(username);
        ds.setPassword(password);
    }

    public static Connection getConn() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("数据库连接异常");
    }

    public static void close(Connection conn, Statement sta, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sta != null) {
                    sta.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
