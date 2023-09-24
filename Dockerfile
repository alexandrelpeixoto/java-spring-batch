FROM public.ecr.aws/d1m5b4i5/amazoncorretto_17
ARG JAR_FILE=target/java-spring-batch-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} java-spring-batch-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-spring-batch-0.0.1-SNAPSHOT.jar"]