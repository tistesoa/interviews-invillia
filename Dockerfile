FROM java:8
VOLUME /tmp
WORKDIR /
ADD interview-invillia-ws/target/interview-invillia-ws-1.0-SNAPSHOT.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.war"]