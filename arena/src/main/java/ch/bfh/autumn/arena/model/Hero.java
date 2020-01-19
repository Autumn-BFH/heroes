package ch.bfh.autumn.arena.model;

import lombok.Data;

@Data
public class Hero {

  private String id;
  private String name;
  private int atk;
  private int def;
  private double hp;
}
