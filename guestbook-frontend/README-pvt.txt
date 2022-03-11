https://www.baeldung.com/spring-debugging
https://stackoverflow.com/questions/44096708/how-to-debug-spring-boot-application-with-intellij-idea-community-edition

mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"

.\mvnw.cmd spring-boot:run -Dspring-boot.run.fork=false -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"


How to get the Maven Tool Window::spring-boot::spring-boot:run option
https://youtrack.jetbrains.com/issue/IDEA-188058
Need to add to frontend pom
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
	from backend pom

C:\Tools\jdk1.8.0_60\bin\java.exe -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:56822,suspend=y,server=n "-Dmaven.multiModuleProjectDirectory=D:\UserData\Documents\PVT\Tutorial\Coursera - Building Scalable Java Microservices with Spring Boot and Spring Cloud\guestbook-frontend" -Dmaven.home=C:\Users\Ken\.m2\wrapper\dists\apache-maven-3.5.3-bin\2c22a6s60afpuloj4v181qvild\apache-maven-3.5.3 -Dclassworlds.conf=C:\Users\Ken\.m2\wrapper\dists\apache-maven-3.5.3-bin\2c22a6s60afpuloj4v181qvild\apache-maven-3.5.3\bin\m2.conf "-Dmaven.ext.class.path=C:\Tools\JetBrains\IntelliJ IDEA Ent 2021.3.2\plugins\maven\lib\maven-event-listener.jar" -javaagent:C:\Users\Ken\AppData\Local\JetBrains\IntelliJIdea2021.3\captureAgent\debugger-agent.jar -Dfile.encoding=UTF-8 -classpath "C:\Users\Ken\.m2\wrapper\dists\apache-maven-3.5.3-bin\2c22a6s60afpuloj4v181qvild\apache-maven-3.5.3\boot\plexus-classworlds-2.5.2.jar;C:\Tools\JetBrains\IntelliJ IDEA Ent 2021.3.2\lib\idea_rt.jar" org.codehaus.classworlds.Launcher -Didea.version=2021.3.2 spring-boot:run
