package com.walter.lychee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.lychee.entity.JpaSysUser;

public interface SysUserRepository extends JpaRepository<JpaSysUser, Long>{

	public JpaSysUser findByUsername(String username);
	
	public List<JpaSysUser> findByUserRealName(String userRealName);
}
