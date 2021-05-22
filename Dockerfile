FROM java:8
ARG JAR_FILE=build/libs/backend-co-air-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} backend-co-ari.jar
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/backend-co-ari.jar"]