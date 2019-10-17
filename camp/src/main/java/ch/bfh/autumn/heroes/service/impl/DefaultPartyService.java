package ch.bfh.autumn.heroes.service.impl;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.model.Party;
import ch.bfh.autumn.heroes.service.PartyService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPartyService implements PartyService {

  private final DefaultHeroService heroService;

  public Party createParty(String name) {
    Party party = new Party();
    party.setName(name);

    List<Hero> heroes = new ArrayList<Hero>(4);
    heroes.add(heroService.createHero("Fabian 1"));
    heroes.add(heroService.createHero("Fabian 2"));
    heroes.add(heroService.createHero("Fabian 3"));
    heroes.add(heroService.createHero("Fabian 4"));

    party.setMembers(heroes);

    System.out.println(party);

    return party;
  }
}
