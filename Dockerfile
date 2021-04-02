FROM java:8
COPY build/libs/our-fight-1.0-SNAPSHOT.jar .
EXPOSE 80
CMD java -jar our-fight-1.0-SNAPSHOT.jar