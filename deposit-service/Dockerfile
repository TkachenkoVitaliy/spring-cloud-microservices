FROM openjdk:11
EXPOSE 9999
COPY /build/libs/deposit-service-1.0-SNAPSHOT.jar .
RUN apt-get -q update && apt-get -qy install netcat
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "bill-service:8082", "--timeout=110", "--", "java", "-jar", "deposit-service-1.0-SNAPSHOT.jar"]