package io.github.cepr0.demo;

import io.github.cepr0.demo.model.Car;
import io.github.cepr0.demo.model.Person;
import io.github.cepr0.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Application {

	private final MongoTemplate mongoTemplate;

	public Application(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * https://www.baeldung.com/spring-data-mongodb-transactions
	 */
	@Profile("replSet")
	@Bean
	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}

	/**
	 * Multi-document transactions works only for existing collections
	 * https://stackoverflow.com/a/53501677
	 */
	@Async
	@EventListener
	public void onReady(ApplicationReadyEvent event) {

		if (mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.dropCollection(Person.class);
		}
		mongoTemplate.createCollection(Person.class);

		if (mongoTemplate.collectionExists(Car.class)) {
			mongoTemplate.dropCollection(Car.class);
		}
		mongoTemplate.createCollection(Car.class);

		if (mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.dropCollection(User.class);
		}
		mongoTemplate.createCollection(User.class);
	}
}
