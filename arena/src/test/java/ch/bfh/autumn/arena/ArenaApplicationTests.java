package ch.bfh.autumn.arena;

import ch.bfh.autumn.arena.model.Hero;
import ch.bfh.autumn.arena.service.impl.DefaultBattleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArenaApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void criticalStrike() {
    Hero h1 = new Hero();
    h1.setName("Hero 1");
    h1.setHp(100);
    h1.setAtk(50);
    h1.setDef(50);
    h1.setCrit(30);
    Hero h2 = new Hero();
    h2.setName("Hero 2");
    h2.setHp(100);
    h2.setAtk(50);
    h2.setDef(50);
    h2.setCrit(70);

    DefaultBattleService dbs = new DefaultBattleService();
    for (int i = 0; i < 10 ; i++) {
      dbs.round(h1, h2);
      dbs.round(h2, h1);
    }
  }

}
