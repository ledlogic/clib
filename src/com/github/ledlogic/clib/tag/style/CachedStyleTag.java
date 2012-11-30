package com.github.ledlogic.clib.tag.style;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

/**
 * Tag to store style information.
 */
public class CachedStyleTag extends BodyTagSupport {
	private static final Logger LOG = Logger.getLogger(CachedStyleTag.class);
	private static final long serialVersionUID = 1L;
	
	private String body;
	private String media;
	private String scoped;
	private String type;
	
	@Override
	public int doEndTag() throws JspException {
		cacheStyle();
		return super.doEndTag();
	}
	
	private void cacheStyle() {
		BodyContent bodyContent = getBodyContent();
		String body = bodyContent != null ? bodyContent.getString() : null;
		
		CachedStyle cachedStyle = new CachedStyle();
		cachedStyle.setBody(body);
		cachedStyle.setMedia(media);
		cachedStyle.setScoped(scoped);
		cachedStyle.setType(type);
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		CachedStylesAttribute attr = CachedStylesAttribute.getOrCreateCachedStylesAttribute(request);
		attr.add(cachedStyle);
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
