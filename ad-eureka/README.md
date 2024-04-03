## 单节点配置

  ~~~
  spring:
    application:
      name: ad-eureka
  
  server:
    # 启动端口
    port: 8000
  
  eureka:
    instance:
      #主机
      hostname: localhost
    client:
      # 是否在registry获取注册信息
      fetch-registry: false
      # 是否将自己注册到eureka
      register-with-eureka: false
      service-url:
        # 默认地址
        defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
  
  ~~~

### 打包运行

~~~
mvn clean package -Dmaven.test.skip=true -U
java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar
~~~

## 多节点配置

~~~

# 多节点
# 需要配置host
# 127.0.0.1 adeureka1
# 127.0.0.1 adeureka2
# 127.0.0.1 adeureka3

---
spring:
  application:
    name: ad-eureka
  profiles: adeureka1
server:
  port: 8000
eureka:
  instance:
    hostname: adeureka1
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://adeureka2:8001/eureka/,http://adeureka3:8002/eureka/

---
spring:
  application:
    name: ad-eureka
  profiles: adeureka2
server:
  port: 8001
eureka:
  instance:
    hostname: adeureka2
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://adeureka1:8000/eureka/,http://adeureka3:8002/eureka/

---
spring:
  application:
    name: ad-eureka
  profiles: adeureka3
server:
  port: 8002
eureka:
  instance:
    hostname: adeureka3
    prefer-ip-address: false
  client:
    service-url:
      defaultZone: http://adeureka1:8000/eureka/,http://adeureka2:8001/eureka/
~~~

### 打包运行

~~~
mvn clean package -Dmaven.test.skip=true -U
java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=adeureka1
java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=adeureka2
java -jar ad-eureka/target/ad-eureka-1.0-SNAPSHOT.jar --spring.profiles.active=adeureka3
~~~

