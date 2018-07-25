FROM bridg/java8
ADD start.sh ./start.sh
COPY Exam1/target/Exam1-1.0-SNAPSHOT.jar  /Exam1-1.0-SNAPSHOT.jar
CMD ["./start.sh"]

