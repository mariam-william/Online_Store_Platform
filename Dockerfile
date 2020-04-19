FROM openjdk:8-jdk-alpine
LABEL maintainer="mariammakram1@gmail.com"
EXPOSE 8080
ADD target/OnlineStorePlatform.jar OnlineStorePlatform.jar
ENTRYPOINT ["java","-jar","/OnlineStorePlatform.jar"]
