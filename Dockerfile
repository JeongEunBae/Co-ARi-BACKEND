FROM openjdk:8-jdk-alpine
ENV     USE_PROFILE default
COPY build/libs/*.jar backend-co-ari.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${USE_PROFILE}", "-Dnormal.prop=Normal_A", "-Dsystem.prop=System_B","-jar","/backend-co-ari.jar"]
