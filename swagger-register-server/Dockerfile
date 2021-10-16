FROM adoptopenjdk/openjdk8:x86_64-centos-jre8u-nightly
COPY target/swagger-register-server.jar app.jar
#COPY storage/ ./storage
RUN bash -c 'touch ./app.jar'
EXPOSE 8080
CMD ["java", "-jar","-Dspring.profiles.active=prod", "app.jar"]