package net.welarson.unipup.util;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UUIDIdGenerator implements IdGenerator {

	@Override
	public String generateId() {
		return UUID.randomUUID().toString();
	}

}
