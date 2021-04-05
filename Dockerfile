FROM maven:3.5-jdk-8 AS build
USER root
RUN mkdir -p /app/src
WORKDIR /app
COPY src src
COPY pom.xml .
RUN mvn clean package -Dmaven.test.skip

FROM gcr.io/distroless/java
ENV ARTIFACT_NAME=xss-detector.jar
COPY --from=build /app/target/$ARTIFACT_NAME /usr/app/$ARTIFACT_NAME
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/xss-detector.jar"]