package io.github.cepr0.demo.person.repo;

import io.github.cepr0.demo.model.Car;
import io.github.cepr0.mogo.repo.MongoRepo;

public interface CarRepo extends MongoRepo<Car, String> {
}
