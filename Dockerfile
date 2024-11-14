FROM gradle:8-jdk17-focal AS build

WORKDIR /app

COPY . .

RUN gradle build -i -x test

FROM openjdk:17-jdk-slim AS production

WORKDIR /app

COPY --from=build /app/build/libs/blog-0.0.1.jar app.jar

EXPOSE 9000

ENTRYPOINT java -jar app.jar