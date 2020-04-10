FROM maven:3.5-jdk-8-alpine as build

COPY ./pom.xml /trab/pom.xml
WORKDIR /trab/
RUN mvn dependency:go-offline

COPY ./src/ /trab/src/
RUN mvn clean package

FROM openjdk:8-jre-alpine as deploy

EXPOSE 8081

COPY --from=build /trab/target/TrabalhoGrauAJPA-0.0.1-SNAPSHOT.jar /trab/
WORKDIR /trab/
CMD java -cp TrabalhoGrauAJPA-0.0.1-SNAPSHOT.jar br.unisinos.bd2.app.App
