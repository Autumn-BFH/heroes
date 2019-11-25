package ch.bfh.autumn.heroes.controller;

import ch.bfh.autumn.heroes.model.Hero;
import ch.bfh.autumn.heroes.service.HeroService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroController {

  private final HeroService heroService;

  @GetMapping
  public List<Hero> getHeroes() {
    return this.heroService.getHeroes();
  }

  @GetMapping("/{id}")
  public Hero getHero(@PathVariable String id) {
    return this.heroService.getHero(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public Hero createHero(@RequestBody Hero hero) {
    return this.heroService.createHero(hero);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable String id) {
    this.heroService.deleteHero(id);
  }
}
