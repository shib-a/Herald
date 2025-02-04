FROM gradle:jdk17-corretto
ADD . /src
WORKDIR /src
RUN gradle jar -DskipTests
RUN gradle bootJar
ENTRYPOINT ["java","-jar","build/libs/Service-0.0.1-SNAPSHOT.jar"]