package ch.bfh.autumn.heroes;

import ch.bfh.autumn.heroes.config.ApplicationConfiguration;
import ch.bfh.autumn.heroes.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {

  public static void main(String[] args) {
    AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        ApplicationConfiguration.class);

    PartyService partyService = applicationContext.getBean(PartyService.class);
    partyService.createParty("Party 1");

    applicationContext.close();
  }
}
