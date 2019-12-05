package ch.bfh.autumn.camp.config;

import ch.bfh.autumn.camp.service.HeroService;
import ch.bfh.autumn.camp.service.PartyService;
import ch.bfh.autumn.camp.service.impl.DefaultHeroService;
import ch.bfh.autumn.camp.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bfh.autumn.camp.repository")
//@EnableMongoRepositories(basePackages = "ch.bfh.autumn.camp.repository")
public class ServiceConfiguration {

  @Bean
  public HeroService heroService() {
    return new DefaultHeroService();
  }

  @Bean
  public PartyService partyService() {
    return new DefaultPartyService();
  }

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    factory.setResources(new Resource[]{new ClassPathResource("camp-data.json")});
    return factory;
  }

}