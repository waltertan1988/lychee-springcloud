package com.walter.lychee.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.lychee.entity.JpaSysAction;

public interface SysActionRepository extends JpaRepository<JpaSysAction, Long>{

	public List<JpaSysAction> findByActionCodeIn(Collection<String> actionCodes);
	
	public JpaSysAction findByActionCode(String actionCode);
}
