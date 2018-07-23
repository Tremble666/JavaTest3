FROM registry.saas.hand-china.com/hap-cloud/base:latest

COPY Exam1-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT exec java $JAVA_OPTS  -jar /app.jar

RUN java -cp target/Exam1-1.0-SNAPSHOT.jar com.hand.Exam1