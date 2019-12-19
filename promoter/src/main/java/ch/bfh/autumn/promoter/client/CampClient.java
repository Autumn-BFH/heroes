package ch.bfh.autumn.promoter.client;

import ch.bfh.autumn.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@FeignClient("camp-service")
public interface CampClient {

  @GetMapping("/createParty")
  EntityModel<Party> createParty(@RequestParam(value = "name") String name);

}
