package org.jrest.context;

import javax.servlet.http.HttpServletRequest;

import com.google.inject.Provider;

public class HttpRequestProvider implements Provider<HttpServletRequest> {

	public HttpServletRequest get() {
		return IocContextManager.getRequest();
	}
}