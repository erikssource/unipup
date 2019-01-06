package net.welarson.unipup.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.welarson.unipup.model.User;
import net.welarson.unipup.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	private final UserRepository repo;
	
	@Autowired
	public UsersController(UserRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Collection<User> list() {
		return repo.findAllEntities();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable String id) {
		return repo.findEntity(id);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User user) {
		repo.add(user);
	}
}
