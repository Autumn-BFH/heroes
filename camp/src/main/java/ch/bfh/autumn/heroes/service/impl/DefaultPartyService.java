package ch.bfh.autumn.heroes.service.impl;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.model.Party;
import ch.bfh.autumn.heroes.service.HeroService;
import ch.bfh.autumn.heroes.service.PartyService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPartyService implements PartyService {

  private String[] heroes = {"Natalya", "David", "Fabian", "Adrian"};

  private final HeroService heroService;

  public Party createParty(String name) {
    Party party = new Party();
    party.setName(name);

    List<Hero> heroes = new ArrayList<>(4);
    for (String heroName : this.heroes) {
      heroes.add(heroService.createHero(heroName));
    }

    party.setMembers(heroes);

    System.out.println(party);

    return party;
  }
}
