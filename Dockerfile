FROM openjdk:11

RUN mkdir /TrafficRacer

WORKDIR /TrafficRacer

RUN apt-get update
RUN apt-get install curl
RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: {token}" https://api.github.com/repos/Martino99a/TrafficRacerProject/actions/artifacts/41693239/zip --output TrafficRacer.zip

RUN unzip TrafficRacer.zip

CMD ["java", "-jar", "TrafficRacer-1.0.jar"]
