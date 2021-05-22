FROM openjdk:8-jdk-alpine
COPY build/libs/*.jar backend-co-ari.jar
ENTRYPOINT ["java","-jar","/backend-co-ari.jar"]