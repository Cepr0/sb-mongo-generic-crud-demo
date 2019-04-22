package io.github.cepr0.demo.user;

import io.github.cepr0.crud.api.AbstractCrudController;
import io.github.cepr0.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends AbstractCrudController<User, String, UserRequest, UserResponse> {

	public UserController(final UserService service) {
		super(service);
	}

	@PostMapping
	@Override
	public ResponseEntity<UserResponse> create(@RequestBody final UserRequest request) {
		return super.create(request);
	}

	@PatchMapping("/{id}")
	@Override
	public ResponseEntity<UserResponse> update(@PathVariable("id") final String id, @RequestBody final UserRequest request) {
		return super.update(id, request);
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity delete(@PathVariable("id") final String id) {
		return super.delete(id);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<UserResponse> getOne(@PathVariable("id") final String id) {
		return super.getOne(id);
	}

	@GetMapping
	@Override
	public ResponseEntity<Page<UserResponse>> getAll(final Pageable pageable) {
		return super.getAll(pageable);
	}
}
