package com.github.ledlogic.clib.tag.style;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

import com.github.ledlogic.clib.tag.cache.CachedFragment;

/**
 * Tag to render the cached style and link contents.
 */
public class CachedStyleRenderTag extends BodyTagSupport {
	private static final Logger LOG = Logger.getLogger(CachedStyleRenderTag.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doEndTag() throws JspException {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			CachedStylesAttribute attr = CachedStylesAttribute.getCachedStylesAttribute(request);
			if (!CollectionUtils.isEmpty(attr)) {
				StringBuffer styleString = new StringBuffer();
				CachedStyleVelocityEngine singleton = CachedStyleVelocityEngine.getSingleton();
				for (CachedFragment fragment: attr) {
					styleString.append(singleton.getStyleString(fragment));
				}
				JspWriter out = pageContext.getOut();
				out.println(styleString);
				attr.clear();
			}
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		return super.doEndTag();		
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
