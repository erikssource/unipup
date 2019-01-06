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

import net.welarson.unipup.model.Course;
import net.welarson.unipup.repository.CourseRepository;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

	private final CourseRepository repo;
	
	@Autowired
	public CoursesController(CourseRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Collection<Course> list() {
		return repo.findAllEntities();
	}
	
	@GetMapping("/{id}")
	public Course findById(@PathVariable String id) {
		return repo.findEntity(id);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Course course) {
		repo.add(course);
	}
}
