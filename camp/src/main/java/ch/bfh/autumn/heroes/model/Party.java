package ch.bfh.autumn.heroes.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Party extends RepresentationModel {

  private String name;
  private List<Hero> members;
}
