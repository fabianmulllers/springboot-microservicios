FROM openjdk:17
VOLUME /tmp
ADD ./target/springboot-servicio-productos-0.0.1-SNAPSHOT.jar servicio-productos-server.jar
ENTRYPOINT ["java","-jar","/servicio-productos-server.jar"]