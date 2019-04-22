package io.github.cepr0.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document("people")
@TypeAlias("person")
public class Person extends BaseDoc {
	private String name;
	@DBRef private Set<Car> cars = new HashSet<>();
}