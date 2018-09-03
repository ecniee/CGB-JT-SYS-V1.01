package com.jt.sys.service;

import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;

public interface SysRoleService {
	
	  int updateObject(
			  SysRole entity,
			  Integer[] menuIds);
	  /**
	   * 基于角色ID查询角色自身信息以及对应的
	   * 菜单id
	   * @param id
	   * @return
	   */
	  Map<String,Object> findObjectById(
			  Integer id);
	  
	  /**
	   * 将角色以及角色与菜单的关系数据
	   * 写入到数据库中
	   * @param entity
	   * @param menuIds
	   * @return
	   */
	  int saveObject(SysRole entity,
			  Integer[] menuIds);
	   /**
	   * 基于角色id删除角色自身信息以及关系数据 
	   * @param id
	   * @return
	   */
	   int deleteObject(Integer id);

	   PageObject<SysRole> findPageObjects(
			   String name,
			   Integer pageCurrent);
}
