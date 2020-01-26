package ch.bfh.autumn.promoter.service.impl;

import ch.bfh.autumn.promoter.client.ArenaClient;
import ch.bfh.autumn.promoter.client.CampClient;
import ch.bfh.autumn.promoter.model.Party;
import ch.bfh.autumn.promoter.service.PromoterService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultPromoterService implements PromoterService {

  private static final Logger LOG = LoggerFactory.getLogger(DefaultPromoterService.class);

  private final CampClient campClient;
  private final ArenaClient arenaClient;

  @Override
  public String promoteFight() {
    Party challengee = campClient.createParty("Challengee").getContent();
    Party challenger = campClient.createParty("Challenger").getContent();

    return startFight(challenger, challengee);
  }

  @Override
  public String promoteFight(Party challenger, Party challengee) {
    return startFight(challenger, challengee);
  }

  private String startFight(Party challenger, Party challengee) {
    LOG.info(
        "Der heutige Kampf ist zwischen der Gruppe '" + challengee.getName() + "' und der Gruppe '" + challenger
            .getName() + "'.");

    List<Party> challengers = new ArrayList<>();
    challengers.add(challengee);
    challengers.add(challenger);

    String winner = arenaClient.battle(challengers);

    if (null != winner) {
      LOG.info("Und der Gewinner ist: Grupe '" + winner + "'");

      return "Der Promoter verkündet mit Stolz den Gewinner des heutigen Kampfes: " + winner;
    } else {
      return "Die Arena wird derzeit gereinigt. Bitte versuche es später noch einmal!";
    }
  }
}
