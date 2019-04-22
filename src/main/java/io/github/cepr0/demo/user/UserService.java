package io.github.cepr0.demo.user;

import io.github.cepr0.crud.service.AbstractCrudService;
import io.github.cepr0.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User, String, UserRequest, UserResponse> {
	protected UserService(final UserRepo repo, final UserMapper mapper) {
		super(repo, mapper);
	}
}
