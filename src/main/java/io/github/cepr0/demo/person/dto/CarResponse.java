package io.github.cepr0.demo.person.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.cepr0.crud.dto.CrudResponse;
import lombok.Data;

@Data
public class CarResponse implements CrudResponse<String> {
	private String id;
	private String brand;
	private String model;
	private Integer year;
	@JsonIgnoreProperties("cars") private PersonDto person;
}
