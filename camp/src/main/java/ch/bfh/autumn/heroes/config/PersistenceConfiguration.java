package ch.bfh.autumn.heroes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// TODO why isn't this automatically discovered?
// annotation needed in Application
@Configuration
@EnableMongoRepositories
public class PersistenceConfiguration {

}
