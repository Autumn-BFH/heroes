package ch.bfh.autumn.repository;

import ch.bfh.autumn.model.Hero;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface HeroRepository extends MongoRepository<Hero, String> {
public interface HeroRepository extends CrudRepository<Hero, String> {

  Long countByAtkGreaterThan(Integer atk);

}

