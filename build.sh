mvn clean package

docker build . -f ./docker/mysql/Dockerfile -t cj/mysql:1.0-my

docker build . -f ./docker/java/Dockerfile -t cj/java:1.0-my