package com.walter.lychee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.lychee.entity.JpaSysUserRole;

public interface SysUserRoleRepository extends JpaRepository<JpaSysUserRole, Long>{

	public List<JpaSysUserRole> findByUsername(String username);
}
