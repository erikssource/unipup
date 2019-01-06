package net.welarson.unipup.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IdentifiedEntity, Serializable {
	private static final long serialVersionUID = -1252234072609867645L;
	
	private String id;	
	private String name;
	private String email;
	private List<String> courses;
}

