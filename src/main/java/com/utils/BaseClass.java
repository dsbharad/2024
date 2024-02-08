package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseClass implements ToBePickedForExecution {

	private final Logger log = LogManager.getLogger(BaseClass.class);

	public Logger getLog() {
		return log;
	}

	@Override
	public abstract void solve();

	@Override
	public abstract void populateData();

}
