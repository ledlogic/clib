package com.github.ledlogic.clib.catalysts;

import junit.framework.Assert;

import org.junit.Test;

public class JsCatalystTest {

	@Test
	public void testCompress() {
		JsCatalyst cat = new JsCatalyst();
		String comp = cat.compress("inline", "function test() { alert(1); }");
		Assert.assertEquals("function test(){alert(1)};", comp);
	}
}
