package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "arena")
public interface ArenaClient {

  @PostMapping("/battle")
  String battle(List<Party> challengers);
}
