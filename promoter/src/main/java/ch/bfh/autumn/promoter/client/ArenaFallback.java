package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ArenaFallback implements ArenaClient {

  @Override
  public String battle(List<Party> challengers) {
    return null;
  }
}
