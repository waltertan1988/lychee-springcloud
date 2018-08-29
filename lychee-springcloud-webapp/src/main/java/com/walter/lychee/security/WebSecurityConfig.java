package com.walter.lychee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;

import com.walter.lychee.entity.JpaSysAction;
import com.walter.lychee.entity.JpaSysMenu;
import com.walter.lychee.entity.JpaSysRoleResource;
import com.walter.lychee.entity.enumeration.SysResourceTypeEnum;
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
//		super.configure(http);

		ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
		
		LinkedMultiValueMap<String, String> menuMap = new LinkedMultiValueMap<String, String>();
		LinkedMultiValueMap<String, String> actionMap = new LinkedMultiValueMap<String, String>();
		for (JpaSysRoleResource res : sysRoleResourceRepository.findAll()) {
			if (res.getResourceType().sameAs(SysResourceTypeEnum.MENU)) {
				menuMap.add(res.getResourceCode(), res.getRoleCode());
			}

			if (res.getResourceType().sameAs(SysResourceTypeEnum.ACTION)) {
				actionMap.add(res.getResourceCode(), res.getRoleCode());
			}
		}
		
		for(JpaSysMenu menu : sysMenuRepository.findByMenuCodeIn(menuMap.keySet())) {
			String[] array = menuMap.get(menu.getMenuCode()).toArray(new String[]{});
			if(array.length > 0) {
				((AuthorizedUrl)registry.regexMatchers(menu.getUri())).hasAnyAuthority(array);
			}
		}
		
		for(JpaSysAction action : sysActionRepository.findByActionCodeIn(actionMap.keySet())) {
			String[] array = actionMap.get(action.getActionCode()).toArray(new String[]{});
			if(array.length > 0) {
				((AuthorizedUrl)registry.regexMatchers(action.getUri())).hasAnyAuthority(array);
			}
		}
		
		((AuthorizedUrl)registry.anyRequest()).permitAll();
	}
}
