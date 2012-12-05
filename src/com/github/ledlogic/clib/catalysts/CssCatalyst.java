package com.github.ledlogic.clib.catalysts;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.yahoo.platform.yui.compressor.CssCompressor;

public class CssCatalyst implements TextCatalyst {
	private static final Logger LOG = Logger.getLogger(CssCatalyst.class);
	
	@Override
	public String compress(String sourceUri, String content) {
		StringReader reader = null;
		StringWriter writer = null;
		String ret = "";
		try {
			reader = new StringReader(content);
			CssCompressor compressor = new CssCompressor(reader);
			writer = new StringWriter();
			compressor.compress(writer, -1);
			writer.flush();
			ret = writer.toString();
			return ret;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}
}