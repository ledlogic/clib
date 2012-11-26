package com.github.ledlogic.clib.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

/**
 * Tag to render the cached contents.
 */
public class CachedScriptRenderTag extends BodyTagSupport {
	private static final Logger LOG = Logger.getLogger(CachedScriptRenderTag.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doEndTag() throws JspException {
		try {
			Date t0 = new Date();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			CachedScriptsAttribute attr = CachedScriptsAttribute.getCachedScriptsAttribute(request);
			if (!CollectionUtils.isEmpty(attr)) {
				StringBuffer scriptString = new StringBuffer();
				JspWriter out = pageContext.getOut();
				CachedScriptVelocityEngine singleton = CachedScriptVelocityEngine.getSingleton();
				for (CachedScript script: attr) {
					scriptString.append(singleton.getScriptString(script));
				}
				Date t1 = new Date();
				long dt = t1.getTime() - t0.getTime();
				LOG.debug("CachedScriptRenderTag - dt[" + dt + "]");
				out.println(scriptString);
				attr.clear();
			}
			return super.doEndTag();
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
