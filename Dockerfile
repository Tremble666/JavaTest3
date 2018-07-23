ADD Exam1-1.0-SNAPSHOT.jar Exam1-1.0-SNAPSHOT.jar

mvn clean package

ADD Exam1/target/Exam1-1.0-SNAPSHOT.jar Exam1-1.0-SNAPSHOT.jar

RUN java -jar Exam1/target/Exam1-1.0-SNAPSHOT.jar

docker build -t Exam1

