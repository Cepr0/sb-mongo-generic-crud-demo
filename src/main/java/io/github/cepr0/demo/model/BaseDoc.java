package io.github.cepr0.demo.model;

import io.github.cepr0.mogo.model.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseDoc extends MongoEntity<String> {
	@Id private String id;
	@Version private Integer version;
}
