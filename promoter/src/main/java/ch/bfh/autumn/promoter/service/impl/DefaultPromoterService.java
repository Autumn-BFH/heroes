package ch.bfh.autumn.promoter.service.impl;

import ch.bfh.autumn.promoter.service.PromoterService;
import ch.bfh.autumn.promoter.client.ArenaClient;
import ch.bfh.autumn.promoter.client.CampClient;
import ch.bfh.autumn.promoter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPromoterService implements PromoterService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultPromoterService.class);

    @Autowired
    private CampClient campClient;

    @Autowired
    private ArenaClient arenaClient;

    @Override
    public String promoteFight() {

        Party challengee = campClient.createParty("Challengee").getContent();
        Party challenger = campClient.createParty("Challenger").getContent();
        LOG.info("Todays battle is between Party '"+challengee.getName()+"' and Party '"+challenger.getName()+"'.");

        List<Party> challengers = new ArrayList<>();
        challengers.add(challengee);
        challengers.add(challenger);
        String winner = arenaClient.battle(challengers);
        LOG.info("And the winner is: Party '"+winner+"'");

        return  winner;
    }
}
