package io.github.cepr0.demo.person.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
@JsonView(Views.ForCar.class)
public class PersonDto {
	private String id;
	private String name;
}
