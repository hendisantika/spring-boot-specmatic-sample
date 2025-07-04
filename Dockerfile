FROM amazoncorretto:21-alpine3.21
LABEL authors="hendisantika"

RUN apk add --no-cache git curl bash && \
    rm -rf /var/cache/apk/*

SHELL ["/bin/bash", "-c"]

WORKDIR /app

EXPOSE 8080

COPY target/specmatic-order-api-1.0-SNAPSHOT.jar /app/order-api.jar

CMD java -jar order-api.jar