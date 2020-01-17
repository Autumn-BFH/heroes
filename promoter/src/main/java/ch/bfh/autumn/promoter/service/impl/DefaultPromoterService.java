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
    LOG.info(
        "Todays battle is between Party '" + challengee.getName() + "' and Party '" + challenger
            .getName() + "'.");

    List<Party> challangers = new ArrayList<>();
    challangers.add(challengee);
    challangers.add(challenger);
    String winner = arenaClient.battle(challangers);
    LOG.info("And the winner is: Party '" + winner + "'");

    return winner;
  }
}
