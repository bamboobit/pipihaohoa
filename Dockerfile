FROM openjdk:8-jdk-alpine3.7
VOLUME /tmp

ADD target/*.jar target/app.jar

EXPOSE 9999

RUN touch target/app.jar

CMD ["java","-Xdebug","-Xnoagent","-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000","-jar","target/app.jar"]
