package io.github.cepr0.demo.user;

import io.github.cepr0.crud.dto.CrudResponse;
import lombok.Data;

@Data
public class UserResponse implements CrudResponse<String> {
	private String id;
	private String name;
}
