clean:
	@mvn clean

package:
	@mvn clean package -Dmaven.test.skip=true -U

run-eureka-test:
	@java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=server1

run-eureka-test:
	@java -jar ad-getway/target/ad-getway-1.0-SNAPSHOT.jar