Profiles are groups of configs/settings, defined by src/main/resources/application-<profile-name>.properties files.
To read more about profiles:
    https://dzone.com/articles/spring-boot-profiles-1
    Overriding profiles location
        https://stackoverflow.com/questions/57083364/spring-boot-default-properties-file-not-being-read-when-using-profile

To run the app with default profile
    Windows
        .\mvnw.cmd -e spring-boot:run
    Linux
        ./mvnw -e spring-boot:run

To run a different profile
    Windows
        .\mvnw.cmd spring-boot:run "-Dspring-boot.run.jvmArguments=-Dspring.profiles.active=cloud"
    Linux
        ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=cloud"

Test via the browser 
	curl http://localhost:8081/guestbookMessages

To Test via curl
	curl -XPOST -H "content-type: application/json" -d "{\"name\": \"Ray\", \"message\": \"Hello CloudSQL\"}" http://localhost:8081/guestbookMessages

To run JUnit tests
	.\mvnw.cmd test