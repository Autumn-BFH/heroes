ARG BUILD_IMAGE=maven:3.5-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim
ARG ANGULAR_IMAGE=node:11-slim

FROM ${ANGULAR_IMAGE} as build-angular
WORKDIR /app
COPY src/main/angular .
RUN npm install
RUN npm run build


FROM ${BUILD_IMAGE} as dependencies
WORKDIR /app
COPY pom.xml ./
RUN mvn -B dependency:go-offline

#############################################################################################

#############################################################################################
###              Stage where Docker is building spring boot app using maven               ###
#############################################################################################
FROM dependencies as build-java


COPY --from=build-angular /app/dist/frontend /app/src/main/resources/static
COPY src ./src

RUN mvn -B clean package -Dmaven.test.skip=true
#############################################################################################

#############################################################################################
### Stage where Docker is running a java process to run a service built in previous stage ###
#############################################################################################
FROM ${RUNTIME_IMAGE}

COPY --from=build-java /app/target/ui-*.jar /app/service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/service.jar"]
#############################################################################################
