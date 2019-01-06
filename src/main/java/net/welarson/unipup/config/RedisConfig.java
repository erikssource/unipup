package net.welarson.unipup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import net.welarson.unipup.model.Course;
import net.welarson.unipup.model.Lesson;
import net.welarson.unipup.model.Module;
import net.welarson.unipup.model.User;

@Configuration
@ComponentScan("net.welarson")
public class RedisConfig {
	
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
	}
	
	@Bean
	public RedisTemplate<String, User> userRedisTemplate() {
		return createRedisTemplate(User.class);
	}
	
	@Bean
	public RedisTemplate<String, Course> courseRedisTemplate() {
		return createRedisTemplate(Course.class);
	}
	
	@Bean 
	public RedisTemplate<String, Module> moduleRedisTemplate() {
		return createRedisTemplate(Module.class);
	}
	
	@Bean RedisTemplate<String, Lesson> lessonRedisTemplate() {
		return createRedisTemplate(Lesson.class);
	}
	
	private <T> RedisTemplate<String, T> createRedisTemplate(Class<T> clazz) {
		final RedisTemplate<String, T> template = new RedisTemplate<String, T>();
		template.setConnectionFactory(lettuceConnectionFactory());
		template.setValueSerializer(new Jackson2JsonRedisSerializer<T>(clazz));
		return template;
	}
}
