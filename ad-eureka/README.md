打包
~~~
mvn clean package -Dmaven.test.skip=true -U
~~~

运行
~~~
java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server1

java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server2

java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server3
~~~