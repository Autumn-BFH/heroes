package ch.bfh.autumn.heroes.model;

import java.util.List;
import lombok.Data;

@Data
public class Party {

  private String name;
  private List<Hero> members;
}
