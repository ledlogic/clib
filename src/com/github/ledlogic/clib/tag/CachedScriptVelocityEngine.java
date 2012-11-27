package com.github.ledlogic.clib.tag;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class CachedScriptVelocityEngine {
	private static final Logger LOG = Logger.getLogger(CachedScriptVelocityEngine.class);
	private static final String SCRIPT_VM = "com/github/ledlogic/clib/tag/script.vm";
	
	private static CachedScriptVelocityEngine singleton = null;
	static {
		singleton = new CachedScriptVelocityEngine();
	}
	
	private Template t;
	
	private CachedScriptVelocityEngine() {
		VelocityEngine ve = new VelocityEngine();
		
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init(p);
		t = ve.getTemplate(SCRIPT_VM, "UTF-8");
	}
	
	public static CachedScriptVelocityEngine getSingleton() {
		return singleton;
	}
	
	public String getScriptString(CachedScript cachedScript) {
		VelocityContext context = getVelocityContext(cachedScript);
		StringWriter writer = new StringWriter();
	    t.merge(context, writer);
	    return writer.toString();
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
