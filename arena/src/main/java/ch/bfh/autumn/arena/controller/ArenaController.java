package ch.bfh.autumn.arena.controller;

import ch.bfh.autumn.arena.model.Party;
import ch.bfh.autumn.arena.service.BattleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArenaController {

  private final BattleService battleService;

  @PostMapping(value = "/battle")
  public String battle(@RequestBody List<Party> challengers) {

    if (challengers.size() != 2) {
      throw new RuntimeException("Es sind nur 2 Kontrahenten zur gleichen Zeit in der Arena erlaubt.");
    }

    Party challengee = challengers.get(0);
    Party challenger = challengers.get(1);
    String winner = battleService.battle(challengee, challenger);
    return "Der Gewinner zwischen '" + challengee.getName() + "' und '" + challenger
        .getName() + "' war '" + winner + "'!";
  }
}
