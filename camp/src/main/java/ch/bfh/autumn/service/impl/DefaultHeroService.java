package ch.bfh.autumn.service.impl;

import ch.bfh.autumn.model.Hero;
import ch.bfh.autumn.service.HeroService;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class DefaultHeroService implements HeroService {

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

    return hero;
  }
}
