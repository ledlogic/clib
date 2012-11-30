package com.github.ledlogic.clib.tag.cache;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;

public class CachedFragmentVelocityEngine extends VelocityEngine {
	private static final Logger LOG = Logger.getLogger(CachedFragmentVelocityEngine.class);
	
	public CachedFragmentVelocityEngine() {
		super();
		
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		
		init(p);
	}
}
