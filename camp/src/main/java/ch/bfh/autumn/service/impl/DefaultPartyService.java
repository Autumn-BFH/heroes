package ch.bfh.autumn.service.impl;

import ch.bfh.autumn.model.Hero;
import ch.bfh.autumn.model.Party;
import ch.bfh.autumn.repository.HeroRepository;
import ch.bfh.autumn.service.PartyService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPartyService implements PartyService {

  private String[] heroes = {"Natalya","David","Fabian","Adrian"};

  @Autowired
  private HeroRepository heroRepository;

  @Override
  public Party createParty(String name) {
    System.out.println("Creating Party with name: " + name);
    Party party = new Party();
    party.setName(name);

    Iterable<Hero> allHeroes = heroRepository.findAll();
    List<Hero> randomHeroes = new ArrayList<Hero>();
    //TODO: shuffle
    int i = 0;
    for(Hero hero: allHeroes){
      randomHeroes.add(hero);
      System.out.println("Hero " + hero.getName() + " added to party to random list");
      i++;
      if (i > 3) {
        break;
      }
    }

    System.out.println("Adding heroes to party "+name);
    party.setMembers(randomHeroes);

    System.out.println("Party " + name + " has been created");

    return party;
  }
}
