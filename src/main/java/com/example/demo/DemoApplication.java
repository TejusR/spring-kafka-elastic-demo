package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private UserRepository repository;

	@Autowired
	Producer producer;

	@PostMapping("/saveUser")
	public int saveUser(@RequestBody List<User> users) {
		repository.saveAll(users);
		return users.size();
	}

	@GetMapping("/findAll")
	public Iterable<User> findAllUsers() {
		return repository.findAll();
	}

	@GetMapping("/findByFName/{firstName}")

	public List<User> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstname(firstName);
	}


	@PostMapping(value="/post")
	public void sendMessage(@RequestParam("msg") String msg) {
		producer.publishToTopic(msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
