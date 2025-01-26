# openjdk java17
FROM openjdk:17-jdk

# create a work dir.
WORKDIR /app

# copy a jvm app.
COPY demo_project/target/*.jar demo_project.jar

# open port 8080 for a jvm app.
EXPOSE 8080

# startup a jvm app.
ENTRYPOINT ["java","-jar","demo_project.jar"]