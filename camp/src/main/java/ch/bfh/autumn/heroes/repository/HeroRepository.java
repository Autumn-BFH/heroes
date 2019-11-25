package ch.bfh.autumn.heroes.repository;

import ch.bfh.autumn.heroes.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends MongoRepository<Hero, String> {

  Long countByAtkGreaterThan(Integer atk);
}
