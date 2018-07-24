# JavaTest3
JDBC

## 运行
1. 执行./build.sh生成jar包和构建镜像
2. 执行./start.sh生成对应的两个容器
3. （如果运行不成功./start.sh）就执行
```
         $ docker run --name=mytest -itd -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123456 cj/mysql:1.0-my
         $ docker exec -it mytest bash
         $ mysql -u root -p
         $ 123456
         $ create database sakila;use sakila;source sakila-schema.sql;source sakila-data.sql;grant all privileges on *.* to 'cj'@'%' identified by '123456';flush privileges;
         $ exit
         $ docker run --name=javatest -itd -e driver=com.mysql.jdbc.Driver -e ip=192.168.99.100 -e port=3306 -e database=sakila -e user=cj -e password=123456sql -e country-id=3 -e customer-id=3 cj/java:1.0-my
         $ docker exec -it javatest bash
         $ java -jar /root/Exam1-1.0-SNAPSHOT.jar
         $ exit
```

## 第一题完成
City ID | City Name
59 | Batna
63 | Bchar
483 | Skikda
first success
==========================

## 第二题完成
| LINDA | 2005-07-07 18:23:25.0
686 | LINDA | 2005-07-07 18:23:25.0
631 | LINDA | 2005-07-07 18:23:25.0
959 | LINDA | 2005-07-07 18:23:25.0
26 | LINDA | 2005-07-07 18:23:25.0
808 | LINDA | 2005-07-07 18:23:25.0
134 | LINDA | 2005-07-07 18:23:25.0
213 | LINDA | 2005-07-07 18:23:25.0
...
549 | LINDA | 2005-05-28 01:17:09.0
870 | LINDA | 2005-05-28 01:17:09.0
724 | LINDA | 2005-05-28 01:17:09.0
44 | LINDA | 2005-05-28 01:17:09.0
120 | LINDA | 2005-05-28 01:17:09.0
895 | LINDA | 2005-05-28 01:17:09.0
236 | LINDA | 2005-05-28 01:17:09.0
303 | LINDA | 2005-05-28 01:17:09.0
second success