package ch.bfh.autumn.arena.service;

import ch.bfh.autumn.arena.model.Party;

public interface BattleService {

  String battle(Party challengee, Party challenger);
}
