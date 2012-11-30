package com.github.ledlogic.clib.tag.style;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.ledlogic.clib.tag.cache.CachedFragment;

/**
 * Session entity for tracking an array of style and link blocks.
 */
public class CachedStylesAttribute extends ArrayList<CachedFragment> {
	private static final long serialVersionUID = 1L;
	
	public static final String CLIB_CACHED_STYLES = "CLIB_CACHED_STYLES";
	
	public CachedStylesAttribute() {
		super();
	}
	
	public static CachedStylesAttribute getCachedStylesAttribute(HttpServletRequest request) {
		CachedStylesAttribute ret = (CachedStylesAttribute)request.getAttribute(CLIB_CACHED_STYLES);
		return ret;
	}
	
	public static CachedStylesAttribute getOrCreateCachedStylesAttribute(HttpServletRequest request) {
		CachedStylesAttribute ret = getCachedStylesAttribute(request);
		if (ret == null) {
			ret = new CachedStylesAttribute();
			request.setAttribute(CLIB_CACHED_STYLES, ret);
		}
		return ret;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}