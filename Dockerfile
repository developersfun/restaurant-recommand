# Use the official OpenJDK 19 Corretto image as the base image
FROM --platform=linux/x86_64 amazoncorretto:19-alpine-jdk

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot application JAR file and its dependencies into the container
COPY /target/restaurant-recommend-0.0.1-SNAPSHOT.jar /app/restaurant-recommend-0.0.1-SNAPSHOT.jar

# Expose the port that the application will listen on
EXPOSE 2023

RUN curl -fsSLO https://get.docker/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz \

# Set the default command to run when the container starts Test Command
CMD ["java", "-jar", "/app/restaurant-recommend-0.0.1-SNAPSHOT.jar"]