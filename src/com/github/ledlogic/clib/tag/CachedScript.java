package com.github.ledlogic.clib.tag;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Bean for storing script tag information.
 */
public class CachedScript implements Serializable {
	private static final long serialVersionUID = 1L;

	private String async;
	private String body;
	private String charset;
	private String defer;
	private String src;
	private String type;
	
	public String getAsync() {
		return async;
	}

	public void setAsync(String async) {
		this.async = async;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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
	}	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}