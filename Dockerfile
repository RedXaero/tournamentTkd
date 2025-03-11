FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
ADD ./target/tournamentTkd-0.0.1-SNAPSHOT.jar tournament.jar

ENTRYPOINT ["java", "-jar", "/tournament.jar"]