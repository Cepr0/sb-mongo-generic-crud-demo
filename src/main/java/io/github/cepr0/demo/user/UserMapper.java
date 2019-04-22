package io.github.cepr0.demo.user;

import io.github.cepr0.crud.mapper.CrudMapper;
import io.github.cepr0.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(config = CrudMapper.class)
public abstract class UserMapper implements CrudMapper<User, UserRequest, UserResponse> {
}
