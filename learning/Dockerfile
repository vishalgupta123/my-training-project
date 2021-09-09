FROM tomcat:9.0

MAINTAINER Vishal Gupta "vishnxxxxx@gmail.com"

EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/learning-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]