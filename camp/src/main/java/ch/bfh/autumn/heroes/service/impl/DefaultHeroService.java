package ch.bfh.autumn.heroes.service.impl;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.service.HeroService;
import org.springframework.stereotype.Service;

@Service
public class DefaultHeroService implements HeroService {

  public Hero createHero(String name) {
    Hero hero = new Hero();

    hero.setName(name);
    hero.setHp(100);

    hero.setAtk(getRandomInRange(1, 100));
    hero.setDef(getRandomInRange(1, 100));

    System.out.println(hero);

    return hero;
  }

  private int getRandomInRange(int min, int max) {
    return (int) (Math.random() * ((max - min) + 1)) + min;
  }
}
