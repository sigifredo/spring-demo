package com.nullpoint.demo.components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("example1Component")
public class Example1Component {

	private static final Log LOGGER = LogFactory.getLog(Example1Component.class);

	public void sayHello() {
		LOGGER.info("hello from Example1Component");
	}
}
