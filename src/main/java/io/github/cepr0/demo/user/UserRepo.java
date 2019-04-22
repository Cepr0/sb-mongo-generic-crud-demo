package io.github.cepr0.demo.user;

import io.github.cepr0.demo.model.User;
import io.github.cepr0.mogo.repo.MongoRepo;

public interface UserRepo extends MongoRepo<User, String> {
}
