FROM centos:7

ENV JAVA_VERSION 1.8.0

COPY assets/entrypoint.sh /app/entrypoint.sh

# Upgrading system
RUN yum -y upgrade

# Downloading & Config Java 8
RUN yum update -y
RUN yum install -y java-$JAVA_VERSION-openjdk java-$JAVA_VERSION-openjdk-devel && \
	yum clean all
  
RUN groupadd springboot && \
	useradd -m -g springboot springboot && \
 	chmod 555 /app/entrypoint.sh
 	
RUN cp /usr/share/zoneinfo/Europe/Madrid /etc/localtime && \
	echo "Europe/Madrid" >  /etc/timezone

# service port
EXPOSE 8080
# debug port
EXPOSE 8000

VOLUME /tmp

WORKDIR /app

USER springboot


COPY spring-boot.jar /app/spring-boot.jar

ENTRYPOINT ["./entrypoint.sh"]

