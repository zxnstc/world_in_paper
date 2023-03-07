FROM williamyeh/java8

COPY *.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]