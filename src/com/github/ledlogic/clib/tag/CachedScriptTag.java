package com.github.ledlogic.clib.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

/**
 * Tag to call the Content Library.
 */
public class CachedScriptTag extends BodyTagSupport {
	private static final Logger LOG = Logger.getLogger(CachedScriptTag.class);
	private static final long serialVersionUID = 1L;
	
	private String async;
	private String charset;
	private String defer;
	private String src;
	private String type;
	
	@Override
	public int doEndTag() throws JspException {
		cacheScript();
		return super.doEndTag();
	}
	
	private void cacheScript() {
		BodyContent bodyContent = getBodyContent();
		String body = bodyContent != null ? bodyContent.getString() : null;
		
		CachedScript cachedScript = new CachedScript();
		cachedScript.setAsync(async);
		cachedScript.setBody(body);
		cachedScript.setCharset(charset);
		cachedScript.setDefer(defer);
		cachedScript.setSrc(src);
		cachedScript.setType(type);
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		CachedScriptsAttribute attr = CachedScriptsAttribute.getOrCreateCachedScriptsAttribute(request);
		attr.add(cachedScript);
	}
	
	public String getAsync() {
		return async;
	}

	public void setAsync(String async) {
		this.async = async;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getDefer() {
		return defer;
	}

	public void setDefer(String defer) {
		this.defer = defer;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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
