FROM tomcat

RUN apt-get update && apt-get -y upgrade

WORKDIR .

COPY target/mais-consulta-0.0.1-SNAPSHOT.jar app.jar

CMD java -jar app.jar

EXPOSE 8080 1433 587
