# Step 1: Using a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Create a directory for the app
WORKDIR /app

# Step 3: Copy the JAR file from your build folder to the container
COPY target/*.jar app.jar

# Step 4: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]