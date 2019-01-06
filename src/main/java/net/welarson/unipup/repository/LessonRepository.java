package net.welarson.unipup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import net.welarson.unipup.model.Lesson;
import net.welarson.unipup.util.IdGenerator;

@Repository
public class LessonRepository extends AbstractRepository<Lesson> {
	private static final String KEY = "lesson";
	
	@Autowired
	public LessonRepository(RedisTemplate<String, Lesson> redisTemplate, IdGenerator idGenerator) {
		super(KEY, redisTemplate, idGenerator);
	}
}
