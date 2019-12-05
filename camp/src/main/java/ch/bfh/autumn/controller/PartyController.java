package ch.bfh.autumn.controller;

import ch.bfh.autumn.model.Hero;
import ch.bfh.autumn.model.Party;
import ch.bfh.autumn.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    PartyService partyService;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @GetMapping
    public Party createParty(@RequestParam String name) {
        Party party = partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());
        for (int i = 0; i < party.getMembers().size(); i++) {
            party.add(entityLinks.linkToItemResource(Hero.class, party.getMembers().get(i).getId()).withRel("hero"+i));
        }
        return party;
    }
}
