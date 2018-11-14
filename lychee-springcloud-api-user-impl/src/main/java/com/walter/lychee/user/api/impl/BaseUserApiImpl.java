package com.walter.lychee.user.api.impl;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public abstract class BaseUserApiImpl {

	protected Logger log = Logger.getLogger(this.getClass());
}
