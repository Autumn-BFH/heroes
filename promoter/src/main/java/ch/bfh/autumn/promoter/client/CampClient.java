package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import org.springframework.hateoas.Resource;

public interface CampClient {

  Resource<Party> createParty(String name);
}
