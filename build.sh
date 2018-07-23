mvn clean install;

docker pull mysql;

cd docker/mysql

docker build -t longhe1996/mysqlnew:1.0 .

cd..

cd java

docker build -t longhe1996/javatest3:1.0 .