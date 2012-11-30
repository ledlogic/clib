package com.github.ledlogic.clib.tag.style;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.ledlogic.clib.tag.cache.CachedFragment;

/**
 * Bean for storing style tag information.
 */
public class CachedStyle implements CachedFragment {
	private static final long serialVersionUID = 1L;

	private String body;
	private String media;
	private String scoped;
	private String type;
	
	public CachedStyle() {
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getScoped() {
		return scoped;
	}

	public void setScoped(String scoped) {
		this.scoped = scoped;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}