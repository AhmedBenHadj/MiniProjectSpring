# MiniProjectSpring
Mini project for spring


# What you’ll build

You’ll build a simple Spring application with some HTTP endpoints exposing an API. You will test just the web layer using JUnit and Spring’s MockMvc, and then you will use the same tests to generate documentation for the API using Spring REST Docs.



    About 15 minutes

    A favorite text editor or IDE

    JDK 1.8 or later

    Gradle 4+ or Maven 3.2+

    You can also import the code straight into your IDE:

        Spring Tool Suite (STS)

        IntelliJ IDEA


# How to complete this guide

Like most Spring Getting Started guides, you can start from scratch and complete each step or you can bypass basic setup steps that are already familiar to you. Either way, you end up with working code.

To start from scratch, move on to Build with Gradle.

To skip the basics, do the following:

    Download and unzip the source repository for this guide, or clone it using Git: git clone https://github.com/spring-guides/gs-testing-restdocs.git

    cd into gs-testing-restdocs/initial

    Jump ahead to Create a simple application.

# When you finish, you can check your results against the code in gs-testing-restdocs/complete.

First you set up a basic build script. You can use any build system you like when building apps with Spring, but the code you need to work with Maven is included here. If you’re not familiar with Maven, refer to Building Java Projects with Maven.



In a project directory of your choosing, create the following subdirectory structure; for example, with mkdir -p src/main/java/hello on *nix systems:

└── src
    └── main
        └── java
            └── Entity
            └── Service
            └── Repository
            └── RestAPI
            └── MainApplication
# pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.springframework</groupId>
    <artifactId>gs-testing-restdocs</artifactId>
    <version>0.1.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.6.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>



The Spring Boot Maven plugin provides many convenient features:

    It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.

    It searches for the public static void main() method to flag as a runnable class.

    It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any version you wish, but it will default to Boot’s chosen set of versions.

# Make the application executable

Create a "main" class that you can use to launch the application:

src/main/java/hello/Application.java

package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



@SpringBootApplication is a convenience annotation that adds all of the following:

    @Configuration tags the class as a source of bean definitions for the application context.

    @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

    Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

    @ComponentScan tells Spring to look for other components, configurations, and services in the the hello package, allowing it to find the HelloController.

The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there wasn’t a single line of XML? No web.xml file either. This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.

