package ch.bfh.autumn.camp;

import ch.bfh.autumn.camp.repository.HeroRepository;
import ch.bfh.autumn.camp.service.HeroService;
import ch.bfh.autumn.camp.service.PartyService;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CampApplicationRunner.class);

    @Autowired
    private PartyService partyService;

    @Autowired
    private HeroService heroService;

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        NameGenerator generator = new NameGenerator();
        List<Name> randNames = generator.generateNames( 50 );

        randNames.forEach((randName) -> {
            heroService.createHero(randName.getFirstName());
        });

        partyService.createParty("Party1");
        LOG.info("Heroes with ATK greater than 50: " + heroRepository.countByAtkGreaterThan(50));
        //heroRepository.findHeroesByAtkGreaterThan(50).forEach(item->LOG.info(item.getName()));
    }
}