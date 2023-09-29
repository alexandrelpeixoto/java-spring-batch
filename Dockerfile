FROM alpine:3.17

ARG version=17.0.8.8.1
ARG JAR_FILE=target/java-spring-batch-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} java-spring-batch-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-spring-batch-0.0.1-SNAPSHOT.jar"]