package ch.bfh.autumn.heroes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Hero {

  @Id
  private String id;
  private String name;
  private int atk;
  private int def;
  private int hp;
}
