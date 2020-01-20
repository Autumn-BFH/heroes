package ch.bfh.autumn.heroes.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.model.Party;
import ch.bfh.autumn.heroes.service.PartyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartyController {

  private final PartyService partyService;

  @GetMapping("createParty")
  public Party createParty(@RequestParam String name) {
    Party party = partyService.createParty(name);

    party.add(
        linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());

    return addMemberRel(party);
  }

  @PostMapping("createParty")
  public Party createPartyWithMembers(String name, List<Hero> heroes) {
    Party party = partyService.createParty(name, heroes);

    party.add(
        linkTo(methodOn(PartyController.class).createPartyWithMembers(name, heroes)).withSelfRel());

    return addMemberRel(party);
  }

  private Party addMemberRel(Party party) {
    for (int i = 0; i < party.getMembers().size(); i++) {
      party.add(linkTo(Hero.class, party.getMembers().get(i).getId())
          .withRel("hero" + i));
    }

    return party;
  }

}
