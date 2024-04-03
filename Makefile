clean:
	@mvn clean

package:
	@mvn clean package -Dmaven.test.skip=true -U