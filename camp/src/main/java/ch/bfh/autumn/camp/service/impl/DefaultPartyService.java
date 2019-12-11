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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPartyService implements PartyService {

  private static Logger LOG = LoggerFactory.getLogger(DefaultPartyService.class);

  @Autowired
  private HeroRepository heroRepository;

  @Override
  public Party createParty(String name) {
    LOG.info("Creating Party with name: " + name);
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
      LOG.info("Hero " + items.get(randValue).getName() + " from camp added to random party");
    }

    LOG.debug("Adding heroes to party "+name);
    party.setMembers(randomHeroes);

    LOG.info("Party " + name + " has been created");

    return party;
  }
}
