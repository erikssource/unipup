package net.welarson.unipup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import net.welarson.unipup.model.Course;
import net.welarson.unipup.util.IdGenerator;

@Repository
public class CourseRepository extends AbstractRepository<Course> {
	private static final String KEY = "course";
	
	@Autowired
	public CourseRepository(RedisTemplate<String, Course> redisTemplate, IdGenerator idGenerator) {
		super(KEY, redisTemplate, idGenerator);
	}
}
