FROM amazoncorretto:11
COPY "./target/APIusersAccess-1.2.jar" "app.jar"
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]