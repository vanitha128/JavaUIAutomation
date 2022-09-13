FROM markhobson/maven-chrome
WORKDIR /DockerSelenium/.
ADD . /DockerSelenium/.
WORKDIR /DockerSelenium
RUN mvn -e clean install test
ENTRYPOINT ["/bin/bash"]