package ch.bfh.autumn.promoter.controller;

import ch.bfh.autumn.promoter.model.PromoteFightBody;
import ch.bfh.autumn.promoter.service.PromoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromoterController {

  private final PromoterService promoterService;

  @GetMapping(value = "/promoteFight")
  public String promoteFight() {
    return promoterService.promoteFight();
  }

  @PostMapping(value = "/promoteFight")
  public String promoteFight(@RequestBody PromoteFightBody challenge) {
    return promoterService
        .promoteFight(challenge.getChallenger(), challenge.getChallengee());
  }
}
