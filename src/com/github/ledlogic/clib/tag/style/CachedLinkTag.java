package com.github.ledlogic.clib.tag.style;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

/**
 * Tag to store link information.
 */
public class CachedLinkTag extends TagSupport {
	private static final Logger LOG = Logger.getLogger(CachedLinkTag.class);
	private static final long serialVersionUID = 1L;
	
	private String href;
	private String lang;
	private String media;
	private String rel;
	private String sizes;
	// target deprecated in HTML5
	private String type;
	
	@Override
	public int doEndTag() throws JspException {
		cacheLink();
		return super.doEndTag();
	}
	
	private void cacheLink() {
		CachedLink cachedLink = new CachedLink();
		cachedLink.setHref(href);
		cachedLink.setLang(lang);
		cachedLink.setMedia(media);
		cachedLink.setRel(rel);
		cachedLink.setSizes(sizes);
		cachedLink.setType(type);
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		CachedStylesAttribute attr = CachedStylesAttribute.getOrCreateCachedStylesAttribute(request);
		attr.add(cachedLink);
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
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
