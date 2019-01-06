package net.welarson.unipup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import net.welarson.unipup.model.Module;
import net.welarson.unipup.util.IdGenerator;

@Repository
public class ModuleRepository extends AbstractRepository<Module> {
	private static final String KEY = "module";
	
	@Autowired
	public ModuleRepository(RedisTemplate<String, Module> redisTemplate, IdGenerator idGenerator) {
		super(KEY, redisTemplate, idGenerator);
	}
}
