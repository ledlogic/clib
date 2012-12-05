package com.github.ledlogic.clib.catalysts;

import org.apache.log4j.Logger;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

public class CatalystErrorReporter implements ErrorReporter {
	private static final Logger LOG = Logger.getLogger(CatalystErrorReporter.class);
	private String sourceUri;
	
	public CatalystErrorReporter(String sourceUri) {
		super();
		this.sourceUri = sourceUri;
	}
		
	public void warning(String message, String sourceName, int line, String lineSource, int lineOffset) {
		LOG.warn(
			"Catalyst Warning: " +
			"line[" + (line >= 0 ? line + ':' + lineOffset + ':' : "") + "]," + 
			"sourceName["+ sourceName + "]," + 
			"lineSource[" + lineSource + "]," + 
			"message[" + message + "]");
	}
	
	public void error(String message, String sourceName, int line, String lineSource, int lineOffset) {
		LOG.error(
			"Catalyst error: " +
			"line[" + (line >= 0 ? line + ':' + lineOffset + ':' : "") + "]," + 
			"sourceName["+ sourceName + "]," + 
			"lineSource[" + lineSource + "]," + 
			"message[" + message + "]");
	}
		
	public EvaluatorException runtimeError(String message, String sourceName, int line, String lineSource, int lineOffset) {
		error(message, sourceName, line, lineSource, lineOffset);
		return new EvaluatorException(message);
	}

	public String getSourceUri() {
		return sourceUri;
	}

	public void setSourceUri(String sourceUri) {
		this.sourceUri = sourceUri;
	}
}