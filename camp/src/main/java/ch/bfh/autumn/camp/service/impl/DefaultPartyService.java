package ch.bfh.autumn.camp.service.impl;

import ch.bfh.autumn.camp.model.Hero;
import ch.bfh.autumn.camp.model.Party;
import ch.bfh.autumn.camp.repository.HeroRepository;
import ch.bfh.autumn.camp.service.PartyService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPartyService implements PartyService {

  @Autowired
  private HeroRepository heroRepository;

  @Override
  public Party createParty(String name) {
    System.out.println("Creating Party with name: " + name);
    Party party = new Party();
    party.setName(name);

    Iterable<Hero> allHeroes = heroRepository.findAll();
    List<Hero> randomHeroes = new ArrayList<>();
    List<Hero> items = new LinkedList<>();

    allHeroes.forEach(items::add);
    Collections.shuffle(items);
    for (int i = 0; i < 4; i++) {
      Random rand = new Random();
      int randValue = rand.nextInt(items.size());
      randomHeroes.add(items.get(randValue));
      System.out.println("Hero " + items.get(randValue).getName() + " added to party to random list");
    }

    System.out.println("Adding heroes to party "+name);
    party.setMembers(randomHeroes);

    System.out.println("Party " + name + " has been created");

    return party;
  }
}
