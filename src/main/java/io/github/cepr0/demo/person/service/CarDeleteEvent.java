package io.github.cepr0.demo.person.service;

import io.github.cepr0.crud.event.EntityEvent;
import io.github.cepr0.demo.model.Car;

public class CarDeleteEvent extends EntityEvent<Car> {
	public CarDeleteEvent(final Car entity) {
		super(entity);
	}
}
