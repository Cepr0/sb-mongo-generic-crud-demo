package io.github.cepr0.demo.person.service;

import io.github.cepr0.crud.event.EntityEvent;
import io.github.cepr0.crud.service.AbstractCrudService;
import io.github.cepr0.demo.model.Car;
import io.github.cepr0.demo.person.dto.CarRequest;
import io.github.cepr0.demo.person.dto.CarResponse;
import io.github.cepr0.demo.person.mapper.CarMapper;
import io.github.cepr0.demo.person.repo.CarRepo;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractCrudService<Car, String, CarRequest, CarResponse> {

	public CarService(final CarRepo repo, final CarMapper mapper) {
		super(repo, mapper);
	}

	@Override
	protected EntityEvent<Car> onCreateEvent(final Car entity) {
		return new CarCreateEvent(entity);
	}

	@Override
	protected EntityEvent<Car> onUpdateEvent(final Car entity) {
		return new CarUpdateEvent(entity);
	}

	@Override
	protected EntityEvent<Car> onDeleteEvent(final Car entity) {
		return new CarDeleteEvent(entity);
	}
}
