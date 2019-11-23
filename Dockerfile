FROM alpine/git AS git
WORKDIR /home/aplikacja/sender
RUN git clone https://github.com/LED1990/MQsender.git

FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /home/aplikacja/sender
COPY --from=git /home/aplikacja/sender/MQsender/src /home/aplikacja/sender/src
COPY --from=git /home/aplikacja/sender/MQsender/pom.xml /home/aplikacja/sender
RUN mvn -f /home/aplikacja/sender/pom.xml clean install

FROM openjdk:8-jre-alpine
WORKDIR /home/aplikacja/sender
COPY --from=build /home/aplikacja/sender/target/activeMqSender-1.0-SNAPSHOT.jar /home/aplikacja/sender
EXPOSE 9091
ENTRYPOINT ["java", "-jar","activeMqSender-1.0-SNAPSHOT.jar"]
