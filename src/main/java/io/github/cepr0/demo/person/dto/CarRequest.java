package io.github.cepr0.demo.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cepr0.crud.dto.CrudRequest;
import lombok.Data;

@Data
public class CarRequest implements CrudRequest {
	private String brand;
	private String model;
	private Integer year;
	@JsonProperty("personId") private String person;
}
