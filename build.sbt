/*
  General Scala attributes
 */
scalaVersion := "2.12.5"

/*
  General project attributes
 */
organization := "uk.gov.ons"
name := "ONS OpenID"
version := "0.1"
maintainer := "Paul Soule <paul.soule@ext.ons.gov.uk>"
description := "A demo how to use OpenID to secure a REST service"
organizationHomepage := Some(url("http://www.ons.gov.uk"))

/*
  Project dependencies
 */
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.0.1.RELEASE"
    exclude("org.springframework.boot", "spring-boot-starter-tomcat"),
  "org.springframework.boot" % "spring-boot-configuration-processor" % "2.0.1.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-jetty" % "2.0.1.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-actuator" % "2.0.1.RELEASE"
)

/*
  Packaging plugin
 */

// enable the Java app packaging archetype and Ash script (for Alpine Linux, doesn't have Bash)
enablePlugins(JavaAppPackaging, AshScriptPlugin)

// set the main entry point to the application that is used in startup scripts
mainClass in Compile := Some("gov.uk.ons.registers.microservice.MyServiceApplication")

// the Docker image to base on (alpine is smaller than the debian based one (120 vs 650 MB)
dockerBaseImage := "openjdk:8-jre-alpine"

// creates tag 'latest' as well when publishing
dockerUpdateLatest := true