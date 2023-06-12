# FROM openjdk:17-jdk-alpine
# ARG Jar_FILE=target/*.jar
# COPY ${Jar_FILE} app.jar
# ENV DB_HOST=localhost
# ENV DB_PORT=3306
# ENV DB_NAME=propertyListing
# ENV DB_USER=root
# ENV DB_PASSWORD=12345678
# ENTRYPOINT ["java", "-jar", "/app.jar"]


FROM openjdk:17-jdk-alpine
ARG Jar_FILE=target/*.jar
COPY ${Jar_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
