package ch.bfh.autumn.service.impl;

import ch.bfh.autumn.model.Hero;
import ch.bfh.autumn.model.Party;
import ch.bfh.autumn.repository.HeroRepository;
import ch.bfh.autumn.service.HeroService;
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

    List<Hero> allHeroes = heroRepository.findAll();
    Collections.shuffle(allHeroes);
    List<Hero> randomHeroes = allHeroes.subList(0,4);

    System.out.println("Adding heroes to party "+name);
    party.setMembers(randomHeroes);

    System.out.println("Party " + name + " has been created");

    return party;
  }
}
