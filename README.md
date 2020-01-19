# heroes

## Changes made to the original project
- Use Lombok `@Data` instead of `getters` and `setters`
- (depcrecated) Use `spring-boot-starter-data-jpa` instead of single packages
- (depcrecated)  Use `@SpringApplication` instead of manually creating Spring Context
- (depcrecated)  In parent module, added `spring-boot-starter-parent`
- (depcrecated)  Versions in Submodule are gotten from parent module `spring-boot-starter-parent`
- Use `spring-boot-devtools` and `spring-boot-starter-web` for h2 Console, see https://stackoverflow.com/questions/43952259/springboot-accessing-h2-console
- (depcrecated) Not using any `JavaConfig`
- Use Constructor Injection with `@RequiredArgsConstructor`
   - See https://www.baeldung.com/spring-injection-lombok
- do not use parent pom.xml from heroes, to remove dependency
## (depcrecated) Connecting to the h2 console
1. Goto `localhost:8080/h2-console`
2. Use default settings, but change `JDBC URL` to `jdbc:h2:mem:testdb`

See also: 
- https://www.baeldung.com/spring-boot-h2-database

## Access HATEOAS REST APIs
REST APIs are automatically created by `@RepositoryRestResource` with the `spring-boot-starter-data-rest` dependency which under the hood uses HATEOAS.
The APIs are published under `localhost:8080/spring-rest-hateoas/<entity>` where `<entity>` corresponds to either `heroes` or `parties`.

See also:
- https://www.baeldung.com/spring-rest-hal
- https://www.baeldung.com/spring-data-rest-intro
- https://spring.io/guides/gs/accessing-data-rest/
- https://spring.io/guides/tutorials/rest/

### Access HAL Browser
When accessing `localhost:8080/spring-rest-hateoas/` you'll automatically get redirected to the HAL Explorer. 

## Access Spring Boot MVC manual REST APIs
Go to `localhost:8080/api/<entity>`

## Running with mocked MongoDB
Comment out the line `<scope>test</scope>` of the dependency `de.flapdoodle.embed.mongo`.

See also: 
- https://www.baeldung.com/spring-boot-embedded-mongodb

## Creating mock data
Edit the file `resources/data/heroes.json` to add new heroes at startup.

See also: 
- https://www.baeldung.com/spring-data-jpa-repository-populators 

# Änderung der Aufgabenstellung
In gewissen Bereichen haben wir die Aufgabenstellung leicht angepasst. Dies, dass wir noch zusätzliche Sachen lernen und um die Architektur besser aufziehen können.
Folgende Sachen wurden angepasst:

**Änderungen**
- Entfernen des `heroes` (parent) POM: Wir haben das parent POM entfernt, dass die Microservice ohne Abhänigkeit zum parent POM gebaut werden können. Microservices sollten nach uns auch ohne das Parent POM lauffähig sein und daher haben wir uns für diesen Schritt entschieden. Die einzigen Vorteile, welche wir mit dem Parent POM gesehen haben, ist die zentrale Versionsverwaltung der Spring Boot Version, die globalen Abhängigkeiten sowie das bauen aller Module gleichzeitig. Jedoch sollte es unserer Meinung nach in einer Microservice Architektur erlaubt sein, verschiedene Versionen von bspw. Spring Cloud zu verwenden. Unteranderem aufgrund dessen, haben wir das Parent POM gelöscht.  
- Verwenden des neuen Spring Cloud Stacks: Wo möglich haben wir die neuen Komponenten des Spring Cloud Stacks verwendet und auf solche, welche im Maintenance-Mode sindnd zu verzichten.
    - Verwendung von `Spring Cloud Gateway` anstatt von `Netflix Zuul API Gateway`
    - Verwendung von `Spring Cloud LoadBalancer` anstatt von `Netflix Ribbon`
    - Leider konnten wir `Netflix Hystrix` und das `Netflix Hystrix Dashboard` nicht so leicht ersetzen, da `Feign` standardmässig `Hystrix` verwendet. Beim `Ribbon` konnten wir dies konfigurativ ausschalten, bei `Hystrix` leider nicht. Dazu kommt, dass es in der neuen Spring Cloud Welt keinen Ersatz für das `Hystrix Dashboard` gibt, so dass man selbst mit `Micrometer` und `Prometheus` sowie `Grafana` ein Monitoring aufbauen muss. Dies würde jedoch den Rahmen dieses Projektes sprengen. 
   
**Zusätzliches**
- Verwendung von `Spring Actuator` für das bereitstellen von Applikationsinfos (Status, etc.)
- Implementierung von `Spring Boot Admin` als zentrales Management-Dashboard
    - Einbindung des `Hystrix Dashboards` von `promoter` in `Spring Boot Admin`
    - Anzeigen von Logdateien, JMX Infos, etc. im Spring Boot Admin
- Verwendung von `lombok` und dessen Annotationen wie zum Beispiel
    - `@Data` anstatt von `getters` und `setters`, ...
- Verwendung von Constructor Injection im Zusammenhang mit Lombok (Annotation `@RequiredArgsConstructor`)
- Verwendung unterschiedlicher Profile für die Entwicklung und die Docker Umgebung


# Getting started
## Starten der Applikation
### Mit embeded MongoDB
### Mit lokaler MongoDB
## Mockdaten
## Bauen der Applikation

# Profile

# Architektur
## Übersicht
## Module

# Zugänge

# Docker
