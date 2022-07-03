FROM openjdk:11
EXPOSE 8761
COPY /build/libs/registry-1.0-SNAPSHOT.jar .
RUN apt-get -q update && apt-get -qy install netcat
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "config-service:8001", "--timeout=70", "--", "java", "-jar", "registry-1.0-SNAPSHOT.jar"]