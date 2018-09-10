package com.walter.lychee.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.core.Authentication;

public class CustomAffirmativeBased extends AffirmativeBased {

	public CustomAffirmativeBased(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
	}

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException {
		//TODO 决策前，要判断是否要重新获取资源的权限
		super.decide(authentication, object, configAttributes);
	}
}
