package com.github.ledlogic.clib.catalysts;

import junit.framework.Assert;

import org.junit.Test;

public class CssCatalystTest {

	@Test
	public void testCompress() {
		CssCatalyst cat = new CssCatalyst();
		String comp = cat.compress("inline", "body { font-size: 10px; }");
		Assert.assertEquals("body{font-size:10px}", comp);
	}
}
