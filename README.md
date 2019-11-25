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
