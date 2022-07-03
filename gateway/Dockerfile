FROM openjdk:11
EXPOSE 8989
COPY /build/libs/gateway-1.0-SNAPSHOT.jar .
RUN apt-get -q update && apt-get -qy install netcat
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "registry:8761", "--timeout=70", "--", "java", "-jar", "gateway-1.0-SNAPSHOT.jar"]