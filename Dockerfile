# Inherit from another image
#Setting config for your image

FROM openjdk:8-jre-alpine

#image: tag
# my-app:latest

# every port on your container is closed be default
# open the port that your app is running on
EXPOSE 8080

# ADD application to the container (just the executble JAR)
ADD target/sidehustle-1.0.jar app.jar

# What commandes to run inside the container when it starts
# ENTRYPOINT for your application (what happens when it starts)
ENTRYPOINT ["java", "-jar", "app.jar"]
# java -jar app.jar (runs as a command) 