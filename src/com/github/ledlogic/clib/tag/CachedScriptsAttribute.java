package com.github.ledlogic.clib.tag;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Session entity for tracking an array of script blocks.
 */
public class CachedScriptsAttribute extends ArrayList<CachedScript> {
	private static final long serialVersionUID = 1L;
	
	public static final String CLIB_CACHED_SCRIPT = "CLIB_CACHED_SCRIPTS";
	
	public CachedScriptsAttribute() {
		super();
	}
	
	public static CachedScriptsAttribute getCachedScriptsAttribute(HttpServletRequest request) {
		CachedScriptsAttribute ret = (CachedScriptsAttribute)request.getAttribute(CLIB_CACHED_SCRIPT);
		return ret;
	}
	
	public static CachedScriptsAttribute getOrCreateCachedScriptsAttribute(HttpServletRequest request) {
		CachedScriptsAttribute ret = getCachedScriptsAttribute(request);
		if (ret == null) {
			ret = new CachedScriptsAttribute();
			request.setAttribute(CLIB_CACHED_SCRIPT, ret);
		}
		return ret;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}