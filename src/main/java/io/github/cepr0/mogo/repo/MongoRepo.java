package io.github.cepr0.mogo.repo;

import io.github.cepr0.crud.model.IdentifiableEntity;
import io.github.cepr0.crud.repo.CrudRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

import static java.lang.String.format;

@NoRepositoryBean
public interface MongoRepo<T extends IdentifiableEntity<ID>, ID extends Serializable> extends CrudRepo<T, ID>, MongoRepository<T, ID> {
	@Override
	@NonNull
	default T create(@NonNull final T entity) {
		Objects.requireNonNull(entity, "The given entity must not be null!");
		return save(entity);
	}

	@NonNull
	Optional<T> getToUpdateById(@NonNull ID id);

	@Override
	@NonNull
	default <S> Optional<T> update(@NonNull final ID id, S source, @NonNull final BiFunction<S, T, T> mapper) {
		Objects.requireNonNull(source, "The given source must not be null!");
		Objects.requireNonNull(mapper, "The given mapper must not be null!");
		return getToUpdateById(id).map(target -> save(mapper.apply(source, target)));
	}

	@NonNull
	Optional<T> getToDeleteById(@NonNull ID id);

	@Override
	@NonNull
	default Optional<T> del(@NonNull ID id) {
		return getToDeleteById(id).map(found -> {
			delete(found);
			return found;
		});
	}

	@Override
	@NonNull
	Optional<T> getById(@NonNull ID id);

	@NonNull
	default T getOne(@NonNull ID id) {
		return findById(id).orElseThrow(() -> new DocNotFoundException(format("Mongo document with id '%s' not found", id)));
	}

	@Query("{}")
	@Override
	@NonNull
	List<T> getAll();

	@Query("{}")
	@Override
	@NonNull
	Page<T> getAll(@NonNull Pageable pageable);

	@Query("{}")
	@Override
	@NonNull
	List<T> getAll(@NonNull Sort sort);
}
