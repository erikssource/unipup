package net.welarson.unipup.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import net.welarson.unipup.model.IdentifiedEntity;
import net.welarson.unipup.util.IdGenerator;

public abstract class AbstractRepository<T extends IdentifiedEntity> {
	private final String key;
	private final IdGenerator idGenerator;
	private final RedisTemplate<String, T> redisTemplate;
	private HashOperations<String, String, T> hashOperations;
	
	public AbstractRepository(String key, RedisTemplate<String, T> redisTemplate, IdGenerator idGenerator) {
		this.key = key;
		this.redisTemplate = redisTemplate;
		this.idGenerator = idGenerator;
	}
	
	@PostConstruct
	public void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	public void add(final T entity) {
		if (entity.getId() == null) {
			entity.setId(idGenerator.generateId());
			hashOperations.put(key, entity.getId(), entity);
		}
	}
	
	public void delete(final String id) {
		hashOperations.delete(key, id);
	}
	
	public T findEntity(final String id) {
		return hashOperations.get(key, id);
	}
	
	public Collection<T> findAllEntities() {
		Map<String, T> map = hashOperations.entries(key);
		return map != null ? map.values() : Collections.emptyList();
	}
}
