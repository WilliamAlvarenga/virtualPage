FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY /target/virtualPage-0.0.1-SNAPSHOT.jar /app/vitual-app.jar
ENTRYPOINT ["java","-jar","/app/vitual-app.jar"]
