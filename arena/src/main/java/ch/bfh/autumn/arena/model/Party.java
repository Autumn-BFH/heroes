package ch.bfh.autumn.arena.model;

import java.util.List;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class Party extends RepresentationModel {

  private String name;
  private List<Hero> members;
}
