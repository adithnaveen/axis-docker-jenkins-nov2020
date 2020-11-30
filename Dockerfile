FROM openjdk:8 

ADD target/axis-app.jar app.jar 

EXPOSE 9090 

ENTRYPOINT [ "java", "-jar", "app.jar" ]


