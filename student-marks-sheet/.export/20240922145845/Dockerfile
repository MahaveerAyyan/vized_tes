FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -X


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/agent agent
COPY --from=build /app/target/student-marks-sheet-*.jar app.jar
EXPOSE 8080 8778
ENTRYPOINT ["java", "-jar", "app.jar"]

