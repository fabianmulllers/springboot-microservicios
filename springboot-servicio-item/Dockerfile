FROM openjdk:17
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar servicio-items.jar
ENTRYPOINT ["java","-jar","/servicio-items.jar"]