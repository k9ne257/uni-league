FROM openjdk
EXPOSE 8080
ADD target/*.jar  uni-league.jar
ENTRYPOINT ["java","-jar", "uni-league.jar"]
