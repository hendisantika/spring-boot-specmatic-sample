FROM amazoncorretto:25-alpine
LABEL authors="hendisantika"

RUN apk add --no-cache git curl bash && \
    rm -rf /var/cache/apk/*

SHELL ["/bin/bash", "-c"]

WORKDIR /app

EXPOSE 8080

COPY target/specmatic-sample-0.0.1-SNAPSHOT.jar /app/specmatic-sample.jar

CMD ["java", "-jar", "specmatic-sample.jar"]
