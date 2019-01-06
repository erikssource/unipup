package net.welarson.unipup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import net.welarson.unipup.model.User;
import net.welarson.unipup.util.IdGenerator;

@Repository
public class UserRepository extends AbstractRepository<User> {
	private static final String KEY = "user";
	
	@Autowired
	public UserRepository(RedisTemplate<String, User> redisTemplate, IdGenerator idGenerator) {
		super(KEY, redisTemplate, idGenerator);
	}
}
