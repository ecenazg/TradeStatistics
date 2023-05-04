FROM maven:3.8.7-eclipse-temurin-19 as maven

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn dependency:go-offline -B

RUN mvn package

FROM eclipse-temurin:19.0.1_10-jre-alpine

WORKDIR /tradestats

COPY --from=maven target/SmartPulse-Internship-TradeStatistics-jar-with-dependencies.jar ./SmartPulse-Internship-TradeStatistics-jar-with-dependencies.jar

CMD ["java", "-jar", "./SmartPulse-Internship-TradeStatistics-jar-with-dependencies.jar"]