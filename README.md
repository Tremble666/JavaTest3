# JavaTest3
JDBC

## 运行
1. 执行./build.sh生成jar包和构建镜像
2. 执行./start.sh生成对应的两个容器
3. 因为我没有在compose文件中指定command,会出问题，所以请老师手动添加指令，指令如下：

```
         $ docker exec -it mytest bash
         $ mysql -u root -p
         $ 123456
         $ create database sakila;use sakila;source sakila-schema.sql;source sakila-data.sql;
         $ exit
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