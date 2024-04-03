## 必备安装

### JDK

~~~
brew install openjdk@8

export PATH="/usr/local/opt/openjdk@8/bin:$PATH"
export JAVA_HOME=/usr/local/Cellar/openjdk@8/1.8.0+362/libexec/openjdk.jdk/Contents/Home
~~~

### maven

 ~~~
 https://maven.apache.org/download.cgi
 https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip
 https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz
 mkdir -p /usr/local/Cellar/maven@3.8
 tar -xzvf apache-maven-3.8.8-bin.tar.gz -C /usr/local/Cellar/maven@3.8 --strip-components=1
 
 export PATH="/usr/local/Cellar/maven@3.8/bin:$PATH"
 ~~~

### IntelliJ IDEA

~~~
IntelliJ IDEA菜单选择：File->Project Structure->Platform Settings->SDKs->`+`->Add JDK
Cmd+Shift+G切换到/usr/local/Cellar/openjdk@8/1.8.0+362/libexec/openjdk.jdk/Contents/Home目录下

IntelliJ IDEA菜单选择：File->Project Structure->Project Settings
Language level 选中8

IntelliJ IDEA菜单选择：IntelliJ IDEA->settings->Build,Execution,Deployment->Compiler->Java Compiler
找到 Per-module bytecode version
将整个列Target bytecode version修改成8


IntelliJ IDEA菜单选择：IntelliJ IDEA->settings->Build,Execution,Deployment->Build Tools->Maven
找到 Maven home path 修改成 /usr/local/Cellar/maven@3.8
~~~
