package com.github.ledlogic.clib.tag.style;

import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.github.ledlogic.clib.tag.cache.CachedFragment;
import com.github.ledlogic.clib.tag.cache.CachedFragmentVelocityEngine;

public class CachedStyleVelocityEngine {
	private static final Logger LOG = Logger.getLogger(CachedStyleVelocityEngine.class);
	private static final String LINK_VM = "com/github/ledlogic/clib/tag/style/link.vm";
	private static final String STYLE_VM = "com/github/ledlogic/clib/tag/style/style.vm";
	
	private static CachedStyleVelocityEngine singleton = null;
	static {
		singleton = new CachedStyleVelocityEngine();
	}
	
	private Template linkTemplate;
	private Template styleTemplate;
	
	private CachedStyleVelocityEngine() {
		VelocityEngine ve = new CachedFragmentVelocityEngine();
		linkTemplate = ve.getTemplate(LINK_VM, "UTF-8");
		styleTemplate = ve.getTemplate(STYLE_VM, "UTF-8");
	}
	
	public static CachedStyleVelocityEngine getSingleton() {
		return singleton;
	}
	
	public String getLinkString(CachedLink cachedLink) {
		VelocityContext context = getVelocityContext(cachedLink);
		StringWriter writer = new StringWriter();
		linkTemplate.merge(context, writer);
		return writer.toString();
	}
	
	public String getStyleString(CachedFragment fragment) {
		if (fragment instanceof CachedLink) {
			return getStyleString((CachedLink) fragment);
		}
		if (fragment instanceof CachedStyle) {
			return getStyleString((CachedStyle) fragment);
		}
		return null;
	}

	public String getStyleString(CachedStyle cachedStyle) {
		VelocityContext context = getVelocityContext(cachedStyle);
		StringWriter writer = new StringWriter();
	    styleTemplate.merge(context, writer);
	    String ret = writer.toString();
		return ret;
	}
	
	public String getStyleString(CachedLink cachedLink) {
		VelocityContext context = getVelocityContext(cachedLink);
		StringWriter writer = new StringWriter();
	    linkTemplate.merge(context, writer);
	    String ret = writer.toString();
		return ret;
	}
		
	private VelocityContext getVelocityContext(CachedLink cachedLink) {
		VelocityContext context = new VelocityContext();
		putVelocityContext(context, "href", cachedLink.getHref());
		putVelocityContext(context, "lang", cachedLink.getLang());
		putVelocityContext(context, "media", cachedLink.getMedia());
		putVelocityContext(context, "rel", cachedLink.getRel());
		putVelocityContext(context, "sizes", cachedLink.getSizes());
		putVelocityContext(context, "type", cachedLink.getType());
		return context;
	}

	private VelocityContext getVelocityContext(CachedStyle cachedStyle) {
		VelocityContext context = new VelocityContext();
		putVelocityContext(context, "body", cachedStyle.getBody());
		putVelocityContext(context, "media", cachedStyle.getMedia());
		putVelocityContext(context, "scoped", cachedStyle.getScoped());
		putVelocityContext(context, "type", cachedStyle.getType());
		return context;
	}
	
	private void putVelocityContext(VelocityContext context, String name, String value) {
		if (StringUtils.isNotBlank(value)) {
			context.put(name, value);
		}
	}
}
