package ch.bfh.autumn.promoter.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class Party extends ResourceSupport {

  private String name;
  private List<Hero> members;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Hero> getMembers() {
    return members;
  }

  public void setMembers(List<Hero> members) {
    this.members = members;
  }
}