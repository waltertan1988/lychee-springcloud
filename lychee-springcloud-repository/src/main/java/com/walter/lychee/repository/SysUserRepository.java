package com.walter.lychee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.lychee.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{

	public SysUser findByUsername(String username);
	
	public List<SysUser> findByUserRealName(String userRealName);
}
