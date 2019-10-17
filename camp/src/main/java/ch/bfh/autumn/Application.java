package ch.bfh.autumn;

import ch.bfh.autumn.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  public static void main(String[] args) {

    // Application context using annotations for DI - more magic, less control
    AnnotationConfigApplicationContext annotatedContext = new AnnotationConfigApplicationContext();
    annotatedContext.scan("ch.bfh.autumn.service.impl");
    annotatedContext.refresh();

    PartyService partyServiceAnnotated = annotatedContext.getBean(PartyService.class);
    partyServiceAnnotated.createParty("Party1");

    annotatedContext.close();
  }
}
