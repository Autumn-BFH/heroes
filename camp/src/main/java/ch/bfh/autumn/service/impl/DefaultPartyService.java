package ch.bfh.autumn.service.impl;

import ch.bfh.autumn.model.Hero;
import ch.bfh.autumn.model.Party;
import ch.bfh.autumn.service.HeroService;
import ch.bfh.autumn.service.PartyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPartyService implements PartyService {

  private String[] heroes = {"Natalya","David","Fabian,","Adrian"};

  @Autowired
  private HeroService heroService;

  @Override
  public Party createParty(String name) {
    System.out.println("Creating Party with name: " + name);
    Party party = new Party();
    party.setName(name);

    List<Hero> members = new ArrayList<Hero>();
    for(int i = 0; i< heroes.length; i++){
      members.add(heroService.createHero(heroes[i]));
    }

    System.out.println("Adding heroes to party "+name);
    party.setMembers(members);

    return party;
  }
}
