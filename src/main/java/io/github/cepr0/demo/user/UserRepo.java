package io.github.cepr0.demo.user;

import io.github.cepr0.crud.repo.MongoRepo;
import io.github.cepr0.demo.model.User;

public interface UserRepo extends MongoRepo<User, String> {
}
