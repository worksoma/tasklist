FROM docker.io/openjdk:17
RUN wget -d --header="Authorization: token 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" https://maven.pkg.github.com/star-capella/tasklist/inc.monsters/tasklist/1.1.1/tasklist-1.1.1.jar
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=production","/app.jar"]
