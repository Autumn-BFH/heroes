# heroes

## Changes made to the original project
- Use Lombok `@Data` instead of `getters` and `setters`
- Use `spring-boot-starter-data-jpa` instead of single packages
- Use `@SpringApplication` instead of manually creating Spring Context
- In parent module, added `spring-boot-starter-parent`
- Versions in Submodule are gotten from parent module `spring-boot-starter-parent`
- Use `spring-boot-devtools` and `spring-boot-starter-web` for h2 Console, see https://stackoverflow.com/questions/43952259/springboot-accessing-h2-console
- Not using any `JavaConfig`
- Use Constructor Injection with `@RequiredArgsConstructor`

## Connecting to the h2 console
1. Goto `localhost:8080/h2-console`
2. Use default settings, but change `JDBC URL` to `jdbc:h2:mem:testdb`
