package ch.bfh.autumn.config;

import ch.bfh.autumn.service.HeroService;
import ch.bfh.autumn.service.PartyService;
import ch.bfh.autumn.service.impl.DefaultHeroService;
import ch.bfh.autumn.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bfh.autumn.heroes.repository")
//@EnableMongoRepositories(basePackages = "ch.bfh.autumn.heroes.repository")
public class ServiceConfiguration {

  @Bean
  public HeroService heroService() {
    return new DefaultHeroService();
  }

  @Bean
  public PartyService partyService() {
    return new DefaultPartyService();
  }

}