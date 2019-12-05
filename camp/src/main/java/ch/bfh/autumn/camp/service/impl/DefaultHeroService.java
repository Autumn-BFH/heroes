package ch.bfh.autumn.camp.service.impl;

import ch.bfh.autumn.camp.model.Hero;
import ch.bfh.autumn.camp.repository.HeroRepository;
import ch.bfh.autumn.camp.service.HeroService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultHeroService implements HeroService {

  @Autowired
  private HeroRepository heroRepository;

  @Override
  public Hero createHero(String name) {
    System.out.println("Creating Hero with name: " + name);
    Hero hero = new Hero();
    hero.setName(name);

    int atk = new Random().nextInt(100);
    hero.setAtk(atk);
    System.out.println("Hero has " + hero.getAtk() + " attack");

    int def = new Random().nextInt(100);
    hero.setDef(def);
    System.out.println("Hero has " + hero.getDef() + " defense");

    hero.setHp(100);
    System.out.println("Hero has " + hero.getHp() + " health points");

    String id = heroRepository.save(hero).getId();

    System.out.println("Hero " + name + " has been created");

    return heroRepository.findById(id).get();
  }
}
