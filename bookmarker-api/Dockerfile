FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]