package io.github.cepr0.demo.person.api;

import io.github.cepr0.crud.api.AbstractCrudController;
import io.github.cepr0.crud.api.OnCreate;
import io.github.cepr0.crud.api.OnUpdate;
import io.github.cepr0.demo.model.Person;
import io.github.cepr0.demo.person.dto.PersonRequest;
import io.github.cepr0.demo.person.dto.PersonResponse;
import io.github.cepr0.demo.person.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("people")
public class PersonController extends AbstractCrudController<Person, String, PersonRequest, PersonResponse> {
	public PersonController(@NonNull final PersonService service) {
		super(service);
	}

	@PostMapping
	@Override
	@NonNull
	public ResponseEntity<PersonResponse> create(@Validated(OnCreate.class) @RequestBody @NonNull final PersonRequest request) {
		return super.create(request);
	}

	@PatchMapping("/{id}")
	@Override
	@NonNull
	public ResponseEntity<PersonResponse> update(@PathVariable("id") @NonNull final String id, @Validated(OnUpdate.class) @RequestBody @NonNull final PersonRequest request) {
		return super.update(id, request);
	}

	@DeleteMapping("/{id}")
	@Override
	@NonNull
	public ResponseEntity<?> delete(@PathVariable("id") @NonNull final String id) {
		return super.delete(id);
	}

	@GetMapping("/{id}")
	@Override
	@NonNull
	public ResponseEntity<PersonResponse> getOne(@PathVariable("id") @NonNull final String id) {
		return super.getOne(id);
	}

	@GetMapping
	@Override
	@NonNull
	public ResponseEntity<Page<PersonResponse>> getAll(@NonNull Pageable pageable) {
		return super.getAll(pageable);
	}
}
