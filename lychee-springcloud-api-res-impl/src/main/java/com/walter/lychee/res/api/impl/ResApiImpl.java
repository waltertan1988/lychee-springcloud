package com.walter.lychee.res.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walter.lychee.entity.JpaSysMenu;
import com.walter.lychee.res.api.ResApi;

@RestController
public class ResApiImpl extends BaseResApiImpl implements ResApi {
	
	@Override
	public List<JpaSysMenu> listMenu(@PathVariable("username") String username) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<JpaSysMenu>();
	}
}
