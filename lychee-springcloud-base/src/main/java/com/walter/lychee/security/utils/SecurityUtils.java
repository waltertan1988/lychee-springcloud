package com.walter.lychee.security.utils;

import java.util.Date;

public class SecurityUtils {
	
	private static Date authorityUpdatedTime = new Date();
	
	public static void refreshAuthorityUpdatedTime(){
		synchronized(authorityUpdatedTime){
			authorityUpdatedTime = new Date();
		}
	}
	
	public static Date getAuthorityUpdatedTime(){
		return authorityUpdatedTime;
	}
}
