package ch.bfh.autumn.heroes.service.impl;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.model.Party;
import ch.bfh.autumn.heroes.service.HeroService;
import ch.bfh.autumn.heroes.service.PartyService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPartyService implements PartyService {

  private final HeroService heroService;

  public Party createParty(String name) {
    Party party = new Party();
    party.setName(name);

    List<Hero> allHeroes = heroService.getHeroes();
    Collections.shuffle(allHeroes);
    List<Hero> randomHeroes = allHeroes.subList(0, 4);

    party.setMembers(randomHeroes);

    System.out.println(party);

    return party;
  }
}
