package ch.bfh.autumn.promoter.controller;

import ch.bfh.autumn.promoter.service.PromoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromoterController {

  private final PromoterService promoterService;

  @GetMapping(value = "/promoteFight")
  public String promoteFight() {
    String result = promoterService.promoteFight();
    return "The Promoter is proud to proclaim the following result of today's battle: " + result;
  }
}
