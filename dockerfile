#base image 
FROM openjdk:latest

EXPOSE 7474

#copy the jar file of backend appln into the container in the name of app.jar
COPY target/rms-0.0.1-SNAPSHOT.jar app.jar

#run the jar file in the container
ENTRYPOINT ["java","-jar","/app.jar"]