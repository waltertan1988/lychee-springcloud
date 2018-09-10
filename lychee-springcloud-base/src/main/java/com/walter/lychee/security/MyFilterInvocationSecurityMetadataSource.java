package com.walter.lychee.security;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class MyFilterInvocationSecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource {

	private LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap;
	
	public MyFilterInvocationSecurityMetadataSource(
			LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
		super(requestMap);
		this.requestMap = requestMap;
	}
	
	public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getRequestMap(){
		return this.requestMap;
	}
}
