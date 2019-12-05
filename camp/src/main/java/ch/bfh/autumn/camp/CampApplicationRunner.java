package ch.bfh.autumn.camp;

import ch.bfh.autumn.camp.repository.HeroRepository;
import ch.bfh.autumn.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    @Autowired
    private PartyService partyService;

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
      partyService.createParty("Party1");
      System.out.println("Heroes with ATK greater than 50: " + heroRepository.countByAtkGreaterThan(50));
      heroRepository.findHeroesByAtkGreaterThan(50).forEach(item->System.out.println(item.getName()));
    }
}