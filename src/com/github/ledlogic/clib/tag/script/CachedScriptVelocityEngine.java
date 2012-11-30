package com.github.ledlogic.clib.tag.script;

import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.github.ledlogic.clib.tag.cache.CachedFragmentVelocityEngine;

public class CachedScriptVelocityEngine {
	private static final Logger LOG = Logger.getLogger(CachedScriptVelocityEngine.class);
	private static final String SCRIPT_VM = "com/github/ledlogic/clib/tag/script/script.vm";
	
	private static CachedScriptVelocityEngine singleton = null;
	static {
		singleton = new CachedScriptVelocityEngine();
	}
	
	private Template t;
	
	private CachedScriptVelocityEngine() {
		VelocityEngine ve = new CachedFragmentVelocityEngine();
		t = ve.getTemplate(SCRIPT_VM, "UTF-8");
	}
	
	public static CachedScriptVelocityEngine getSingleton() {
		return singleton;
	}
	
	public String getScriptString(CachedScript cachedScript) {
		VelocityContext context = getVelocityContext(cachedScript);
		StringWriter writer = new StringWriter();
	    t.merge(context, writer);
	    String ret = writer.toString();
		return ret;
	}

	private VelocityContext getVelocityContext(CachedScript cachedScript) {
		VelocityContext context = new VelocityContext();
		putVelocityContext(context, "async", cachedScript.getAsync());
		putVelocityContext(context, "body", cachedScript.getBody());
		putVelocityContext(context, "charset", cachedScript.getCharset());
		putVelocityContext(context, "defer", cachedScript.getDefer());
		putVelocityContext(context, "src", cachedScript.getSrc());
		putVelocityContext(context, "type", cachedScript.getType());
		return context;
	}
	
	private void putVelocityContext(VelocityContext context, String name, String value) {
		if (StringUtils.isNotBlank(value)) {
			context.put(name, value);
		}
	}
}
