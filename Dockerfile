#FROM amazoncorretto:21.0.0
FROM icecreamcry/centos:0.2
LABEL authors="iccry"

ENV APP_NAME="mynotes"

COPY target/$APP_NAME.jar app.jar

ENTRYPOINT ["java","-jar", "app.jar"]
