
FROM openjdk:21

WORKDIR /usr/app/

COPY ./javaservice/target/javaservice-1.0-SNAPSHOT.jar .

EXPOSE 3000

# Command to run the Java application
CMD ["java", "-jar", "javaservice-1.0-SNAPSHOT.jar"]