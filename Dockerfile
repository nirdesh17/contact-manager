# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/Contact-Manager-0.0.1-SNAPSHOT.jar /app/ContactManagerApplication.jar

# Expose the port that the application will run on
EXPOSE 8081

# Specify the command to run on container startup
CMD ["java", "-jar", "ContactManagerApplication.jar"]
