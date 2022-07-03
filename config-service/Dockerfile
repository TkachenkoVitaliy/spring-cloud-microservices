FROM openjdk:11
EXPOSE 8001
COPY /build/libs/config-service-1.0-SNAPSHOT.jar .
RUN apt-get -q update && apt-get -qy install netcat
ENTRYPOINT ["java", "-jar", "config-service-1.0-SNAPSHOT.jar"]