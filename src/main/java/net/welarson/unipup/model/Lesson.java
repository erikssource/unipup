package net.welarson.unipup.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson implements IdentifiedEntity, Serializable {
	private static final long serialVersionUID = 8984038090547923479L;
	
	public static final String TYPE_TEXT = "text";
	public static final String TYPE_VIDEO = "video";
	
	private String id;
	private String title;
	private String summary;
	private String content;
}
