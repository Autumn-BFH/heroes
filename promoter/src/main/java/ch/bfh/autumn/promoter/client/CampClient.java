package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {

  EntityModel<Party> createParty(String name);
}
