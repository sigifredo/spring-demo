package com.nullpoint.demo.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	@Qualifier("logRepository")
	private com.nullpoint.demo.repository.LogRepository logRepository;

	private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		String details = "";

		if (auth != null && auth.isAuthenticated()) {
			username = auth.getName();
			details = auth.getDetails().toString();
		}
		logRepository.save(new com.nullpoint.demo.entity.Log(new Date(), details, username, url));

		LOGGER.info("URL to: '" + url + "' in '" + (System.currentTimeMillis() - startTime) + "ms'");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

}
