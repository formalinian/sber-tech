FROM openjdk:18
ARG JAR_FILE=test-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]