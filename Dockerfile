FROM gradle:jdk21 AS build
ENV POSTGRES_USER = postgres
ENV POSTGRES_PASSWORD = admin
RUN mkdir -p /home/app
COPY --chown=gradle:gradle . /home/app/src
WORKDIR /home/app/src
RUN gradle build --no-daemon
RUN mv ./build/libs/jpapractice-0.0.1-SNAPSHOT.jar ./build/libs/spring-application.jar

FROM eclipse-temurin:21-jre-jammy
RUN mkdir /app
COPY --from=build /home/app/src/build/libs/spring-application.jar /app/spring-application.jar
EXPOSE 8080
CMD ["java","-jar","/app/spring-application.jar"]