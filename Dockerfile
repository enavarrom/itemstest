FROM adoptopenjdk/openjdk11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=./build/libs/items-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} items-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/items-0.0.1-SNAPSHOT.jar"]