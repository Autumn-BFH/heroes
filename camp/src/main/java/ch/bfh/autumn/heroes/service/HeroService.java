package ch.bfh.autumn.heroes.service;

import ch.bfh.autumn.heroes.model.Hero;
import java.util.List;

public interface HeroService {

  Hero createHero(String name);

  Hero createHero(Hero hero);

  List<Hero> getHeroes();

  Hero getHero(String id);

  Hero updateHero(Hero hero);

  void deleteHero(String id);
}
