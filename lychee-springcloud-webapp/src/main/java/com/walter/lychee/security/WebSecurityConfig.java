package com.walter.lychee.security;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.walter.lychee.repository.SysActionRepository;
import com.walter.lychee.repository.SysMenuRepository;
import com.walter.lychee.repository.SysRoleResourceRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SysMenuRepository sysMenuRepository;
	@Autowired
	private SysActionRepository sysActionRepository;
	@Autowired
	private SysRoleResourceRepository sysRoleResourceRepository;

	// 用户认证
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	// 请求授权
	@SuppressWarnings("rawtypes")
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					// 自定义授权管理
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
						// 设置自己的securityMetadataSource
						fsi.setSecurityMetadataSource(securityMetadataSource());
						
						// 在AccessDecisionManager中加入RoleVoter
						AbstractAccessDecisionManager accessDecisionManager = (AbstractAccessDecisionManager) fsi
								.getAccessDecisionManager();
						accessDecisionManager.getDecisionVoters().add(roleVoter());
						return fsi;
					}
				})
			.anyRequest()
				.denyAll()
		.and()
			.formLogin()
		.and()
			.httpBasic();
	}

	/**
	 * 动态管理权限需要用此SecurityMetadataSource
	 * @return
	 */
	@Bean
	public DefaultFilterInvocationSecurityMetadataSource securityMetadataSource() {
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
		RequestMatcher requestMatcher1 = new RegexRequestMatcher("/admin/.*", null);
		requestMap.put(requestMatcher1, SecurityConfig.createList("ROLE_ADMIN"));

		return new DefaultFilterInvocationSecurityMetadataSource(requestMap);
	}

	/**
	 * 按角色进行授权决策
	 * 
	 * @return
	 */
	@Bean
	public RoleVoter roleVoter() {
		RoleVoter voter = new RoleVoter();
		voter.setRolePrefix("");
		return voter;
	}
}
