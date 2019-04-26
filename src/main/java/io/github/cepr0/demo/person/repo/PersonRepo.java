package io.github.cepr0.demo.person.repo;

import io.github.cepr0.crud.repo.MongoRepo;
import io.github.cepr0.demo.model.Person;

public interface PersonRepo extends MongoRepo<Person, String> {
//	@Named("findOne")
//	@Override
//	Person findOne(String id);
}
