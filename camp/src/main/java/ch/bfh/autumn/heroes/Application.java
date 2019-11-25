package ch.bfh.autumn.heroes;

import ch.bfh.autumn.heroes.repository.HeroRepository;
import ch.bfh.autumn.heroes.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements ApplicationRunner {

  private final PartyService partyService;
  private final HeroRepository heroRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(this.heroRepository.countByAtkGreaterThan(1));
    System.out.println(this.heroRepository.findAll());
  }
}
