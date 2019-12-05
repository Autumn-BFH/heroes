package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import java.util.List;

public interface ArenaClient {

  String battle(List<Party> challangers);
}
