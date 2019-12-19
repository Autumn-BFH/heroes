package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "arena-service", fallback = ArenaClientFallback.class)
public interface ArenaClient {

  @PostMapping("/battle")
  String battle(@RequestBody List<Party> challengers);

}
