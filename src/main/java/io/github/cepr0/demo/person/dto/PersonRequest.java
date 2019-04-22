package io.github.cepr0.demo.person.dto;

import io.github.cepr0.crud.dto.CrudRequest;
import lombok.Data;

@Data
public class PersonRequest implements CrudRequest {
	private String name;
}
