package ch.bfh.autumn.heroes.service.impl;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.repository.HeroRepository;
import ch.bfh.autumn.heroes.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultHeroService implements HeroService {

  private final HeroRepository heroRepository;

  public Hero createHero(String name) {
    Hero hero = new Hero();

    hero.setName(name);
    hero.setHp(100);

    hero.setAtk(getRandomInRange(1, 100));
    hero.setDef(getRandomInRange(1, 100));

    String heroId = this.heroRepository.save(hero).getId();

    return this.heroRepository.findById(heroId).get();
  }

  private int getRandomInRange(int min, int max) {
    return (int) (Math.random() * ((max - min) + 1)) + min;
  }
}
