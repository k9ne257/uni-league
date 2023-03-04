FROM openjdk
ADD target/*.jar  uni-league.jar
ENTRYPOINT ["java","-jar", "uni-league.jar"]
