# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src

# Make the Maven wrapper executable
RUN chmod +x mvnw

# Build the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose the port Spring Boot will run on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/portfolio-backend-0.0.1-SNAPSHOT.jar"]