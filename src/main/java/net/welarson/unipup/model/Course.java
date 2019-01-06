package net.welarson.unipup.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements IdentifiedEntity, Serializable {
	private static final long serialVersionUID = -5668306826620834755L;

	private String id;
	private String title;
	private String summary;
	private String description;
	private String image;
	private List<String> modules;
	
}
