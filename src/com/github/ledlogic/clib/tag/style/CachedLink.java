package com.github.ledlogic.clib.tag.style;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.ledlogic.clib.tag.cache.CachedFragment;

/**
 * Bean for storing link tag information.
 * 
 * @see http://www.w3.org/TR/html4/struct/links.html
 */
public class CachedLink implements CachedFragment {
	private static final long serialVersionUID = 1L;

	private String href;
	private String lang;
	private String media;
	private String rel;
	private String sizes;
	// target deprecated in HTML5
	private String type;
	
	public CachedLink() {
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,	ToStringStyle.SHORT_PREFIX_STYLE);
	}
}