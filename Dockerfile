FROM alpine/git AS git
WORKDIR /home/aplikacja/reciever
RUN git clone https://github.com/LED1990/MQsender.git

FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /home/aplikacja/reciever
COPY --from=git /home/aplikacja/MQsender/src /home/aplikacja/mqsender/src
COPY --from=git /home/aplikacja/MQsender/pom.xml /home/aplikacja/mqsender
RUN mvn -f /home/aplikacja/mqsender/pom.xml clean install

FROM openjdk:8-jre-alpine
WORKDIR /home/aplikacja/mqsender
COPY --from=build /home/aplikacja/mqsender/target/activeMqSender-1.0-SNAPSHOT.jar /home/aplikacja/mqsender
EXPOSE 9091
ENTRYPOINT ["java", "-jar","activeMqSender-1.0-SNAPSHOT.jar"]
