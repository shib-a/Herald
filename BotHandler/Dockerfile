FROM gradle:jdk17-corretto
ADD . /src
WORKDIR /src
RUN ./gradlew jar -DskipTests
RUN ./gradlew bootJar
ENTRYPOINT ["java","-jar","build/libs/BotHandler-0.0.1-SNAPSHOT.jar"]