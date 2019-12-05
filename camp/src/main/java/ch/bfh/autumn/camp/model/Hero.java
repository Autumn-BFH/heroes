package ch.bfh.autumn.camp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
/*import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;*/

//@Document
@Entity
public class Hero {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
  private String name;
  private int atk;
  private int def;
  private double hp;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAtk() {
    return atk;
  }

  public void setAtk(int atk) {
    this.atk = atk;
  }

  public int getDef() {
    return def;
  }

  public void setDef(int def) {
    this.def = def;
  }

  public double getHp() {
    return hp;
  }

  public void setHp(double hp) {
    this.hp = hp;
  }
}
