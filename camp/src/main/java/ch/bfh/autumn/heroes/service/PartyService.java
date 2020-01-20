package ch.bfh.autumn.heroes.service;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.model.Party;
import java.util.List;

public interface PartyService {

  Party createParty(String name);

  Party createParty(String name, List<Hero> heroList);
}
