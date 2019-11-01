package ch.bfh.autumn.heroes.repository;

import ch.bfh.autumn.heroes.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {

  Long countByAtkGreaterThan(Integer atk);
}
