package io.github.cepr0.demo.person.repo;

import io.github.cepr0.demo.model.Person;
import io.github.cepr0.mogo.repo.MongoRepo;

public interface PersonRepo extends MongoRepo<Person, String> {
}
