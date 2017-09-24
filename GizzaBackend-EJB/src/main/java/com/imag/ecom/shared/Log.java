package com.imag.ecom.shared;

import javax.ejb.Singleton;

import org.apache.log4j.Logger;

/**
 * Session Bean implementation class Log
 */
@Singleton
public class Log {

	final static Logger logger = Logger.getLogger(Log.class);

	public Log() {

	}

	public void logWargin(String message) {
		logger.warn("Warning:" + message);
	}

	public void logInfo(String message) {
		logger.info("Info:" + message);
	}

	public void logError(String message) {
		logger.error("Error:" + message);
	}

}
