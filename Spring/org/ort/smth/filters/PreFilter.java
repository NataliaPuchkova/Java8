package org.ort.smth.filters;

import org.ort.smth.route.service.RouteService;
import org.ort.smth.route.service.RouteServiceImpl;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.servlet.http.HttpServletRequest;

@ConfigurationProperties
public class PreFilter extends ZuulFilter {

	private static final int PRE_DECORATION_FILTER_ORDER = 6;
	private static final String PRE_TYPE = "pre";
	private static final String API_MARKER = "api";
	private static Logger log = LoggerFactory.getLogger(APIFilter.class);

	@Autowired
	private ObjectFactory<RouteService> prototypeFactory;

	@Autowired
	RouteServiceImpl service;

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		if (!request.getRequestURI().contains(API_MARKER)) {
			log.info("Request pre " + request.getRequestURI());
			return true;
		}
		return false;
	}

	@Override
	public Object run() {
		RouteService routeService = prototypeFactory.getObject();
		routeService.route(RequestContext.getCurrentContext());
		return null;
	}


}
