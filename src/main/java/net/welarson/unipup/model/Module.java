package net.welarson.unipup.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module implements IdentifiedEntity, Serializable {
	private static final long serialVersionUID = 498334691557018662L;

	private String id;
	private String title;
	private String summary;
	private List<String> lessons;
}
