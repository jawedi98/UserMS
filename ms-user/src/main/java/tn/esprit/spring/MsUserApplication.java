package tn.esprit.spring;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
	}
	@Bean 
	ApplicationRunner init(UserRepository repository) {
		return args ->{
			Stream.of("Mariem","Sara","Mohamed").forEach(nom ->{
				repository.save(new User(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}
