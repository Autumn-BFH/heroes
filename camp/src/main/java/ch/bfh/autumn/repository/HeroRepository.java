package ch.bfh.autumn.repository;

import ch.bfh.autumn.model.Hero;
//import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
//public interface HeroRepository extends MongoRepository<Hero, String> {
public interface HeroRepository extends CrudRepository<Hero, String> {

  Long countByAtkGreaterThan(Integer atk);

  List<Hero> findHeroesByAtkGreaterThan(Integer atk);
}

