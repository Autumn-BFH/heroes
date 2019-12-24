package ch.bfh.autumn.camp.service.impl;

import ch.bfh.autumn.camp.model.Hero;
import ch.bfh.autumn.camp.repository.HeroRepository;
import ch.bfh.autumn.camp.service.HeroService;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultHeroService implements HeroService {

  private static Logger LOG = LoggerFactory.getLogger(DefaultHeroService.class);

  @Autowired
  private HeroRepository heroRepository;

  @Override
  public Hero createHero(String name) {
    LOG.info("Creating Hero with name: " + name);
    Hero hero = new Hero();
    hero.setName(name);

    int atk = new Random().nextInt(100);
    hero.setAtk(atk);
    LOG.debug("Hero has " + hero.getAtk() + " attack");

    // Between 25 and 100 percent
    int crit = new Random().nextInt((100 - 25) + 1) + 25;;
    hero.setCrit(crit);
    LOG.debug("Hero has " + hero.getCrit() + "% critical chance");

    int def = new Random().nextInt(100);
    hero.setDef(def);
    LOG.debug("Hero has " + hero.getDef() + " defense");

    hero.setHp(100);
    LOG.debug("Hero has " + hero.getHp() + " health points");

    String id = heroRepository.save(hero).getId();

    LOG.info("Hero " + name + " has been created");

    return heroRepository.findById(id).get();
  }
}
