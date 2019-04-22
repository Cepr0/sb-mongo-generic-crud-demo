package io.github.cepr0.demo.user;

import io.github.cepr0.crud.dto.CrudRequest;
import lombok.Data;

@Data
public class UserRequest implements CrudRequest {
	private String name;
}
