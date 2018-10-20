FROM openjdk:8-jdk-alpine
ADD target/app.jar app.jar
#RUN mkdir /config
EXPOSE 8085
ENV JAVA_OPTS="-server -Xmx2G -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
#VOLUME ["/config"]
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]